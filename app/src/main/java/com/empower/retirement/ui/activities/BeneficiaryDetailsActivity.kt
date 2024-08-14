package com.empower.retirement.ui.activities

import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import com.empower.retirement.helpers.convertStringToDate


class BeneficiaryDetailsActivity : BaseActivity() {

    private var items = emptyList<String>()
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout = LinearLayout(this)
        linearLayout.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        linearLayout.orientation = LinearLayout.VERTICAL

        // Set the LinearLayout as the content view
        setContentView(linearLayout)

    }

    override fun onStart() {
        super.onStart()
        populateData()
        populateView()
    }

    private fun populateData() {
        // Get  selected item index and extract data
        viewModel.getSelectionItem(intent.getIntExtra("index", -1)).let { item ->
            items = listOf("SSN: ${item?.ssn}","Phone Number: ${item?.phoneNumber}","Date Of Birth: ${convertStringToDate(item?.dateOfBirth)}", "Address: ${item?.address?.streetName+", "}  ${item?.address?.city+", "}  ${item?.address?.stateCode +", "} ${item?.address?.zipCode} ${item?.address?.country}")
        }
    }


    private fun populateView() {
        // Create a TextView for each item
        items.forEach { item ->
            val textView = TextView(this)
            textView.text = item
            textView.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            textView.textSize = 20f  // Set text size in SP
            textView.setPadding(16, 16, 16, 16)  // Set padding (left, top, right, bottom)
            // Add the TextView to the LinearLayout
            linearLayout.addView(textView)
        }
    }

}