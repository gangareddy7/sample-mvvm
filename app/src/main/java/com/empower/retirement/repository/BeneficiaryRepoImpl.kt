package com.empower.retirement.repository

import com.empower.retirement.config.BeneficiaryApp
import com.empower.retirement.helpers.parseJsonArrayToBeneficiaryListItem
import com.empower.retirement.helpers.readJsonFile
import com.empower.retirement.models.BeneficiaryListItem
import org.json.JSONArray

class BeneficiaryRepoImpl: BeneficiaryRepo {

    override fun getBeneficiaryList(): List<BeneficiaryListItem> {
        // Read json file from asset folder
        val json = readJsonFile(BeneficiaryApp.getContext(), "Beneficiaries.json")
        //convert json to json array
        val jsonArray = JSONArray(json)

        return parseJsonArrayToBeneficiaryListItem(jsonArray)
    }

}