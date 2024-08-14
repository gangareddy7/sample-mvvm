package com.empower.retirement.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import com.empower.retirement.ui.adapters.BeneficiaryCustomAdapter

class BeneficiaryListActivity : BaseActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: BeneficiaryCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        //navigates to detail view activity on click of listview
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, BeneficiaryDetailsActivity::class.java)
            intent.putExtra("index", position)
            startActivity(intent)
        }

        // Set the ListView as the content view of the Activity
        setContentView(listView)

    }

    // Initializes listview, adapterview and set adapter to listview
    private fun init() {
        listView = ListView(this)
        adapter = BeneficiaryCustomAdapter(this)
        listView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        // Observe the items from the ViewModel
        viewModel.list.observe(this) {
            adapter.populateData(it)
        }
    }
}