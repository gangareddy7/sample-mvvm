package com.empower.retirement.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.empower.retirement.models.BeneficiaryListItem

class BeneficiaryCustomAdapter(private val context: Context) :
    BaseAdapter() {

    private val items = mutableListOf<BeneficiaryListItem>()

    fun populateData(list: List<BeneficiaryListItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position) as BeneficiaryListItem

        val view: LinearLayout
        if (convertView == null) {
            view = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                // firstName TextView
                val firstNameTextView = TextView(context).apply {
                    id = View.generateViewId()
                    textSize = 18f
                    setPadding(16, 16, 16, 8)
                }

                // lastName TextView
                val lastNameTextView = TextView(context).apply {
                    id = View.generateViewId()
                    textSize = 18f
                    setPadding(16, 16, 16, 8)
                }

                // beneType TextView
                val beneTypeTextView = TextView(context).apply {
                    id = View.generateViewId()
                    textSize = 14f
                    setPadding(16, 8, 16, 16)
                    setTextColor(0xFF444444.toInt())
                }

                // designation TextView
                val designationTextView = TextView(context).apply {
                    id = View.generateViewId()
                    textSize = 14f
                    setPadding(16, 8, 16, 16)
                    setTextColor(0xFF444444.toInt())
                }

                addView(firstNameTextView)
                addView(lastNameTextView)
                addView(beneTypeTextView)
                addView(designationTextView)

                // Set the IDs to the TextViews in the ViewHolder
                tag = ViewHolder(
                    firstNameTextView,
                    lastNameTextView,
                    beneTypeTextView,
                    designationTextView
                )
            }
        } else {
            view = convertView as LinearLayout
        }

        val viewHolder = view.tag as ViewHolder
        viewHolder.firstName.text = "First Name: " + item.firstName
        viewHolder.lastName.text = "Last Name: " + item.lastName
        viewHolder.beneType.text = "Bene Type: " + item.beneType
        viewHolder.designation.text =
            "Designation: " + destinationCode(item.designationCode)

        return view
    }

    private fun destinationCode(designation: String): String {
        return when (designation) {
            "C" -> "Contingent"
            "P" -> "Primary"
            else -> ""
        }
    }



    private class ViewHolder(
        val firstName: TextView,
        val lastName: TextView,
        val beneType: TextView,
        val designation: TextView,
    )
}
