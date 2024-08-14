package com.empower.retirement.helpers

import android.content.Context
import com.empower.retirement.models.BeneficiaryAddress
import com.empower.retirement.models.BeneficiaryListItem
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

// Read json file from asset folder using AssetManager
fun readJsonFile(context: Context, filename: String): String? {
    val json: String?
    try {
        val inputStream: InputStream = context.assets.open(filename)
        json = inputStream.bufferedReader().use { it.readText() }
        return json
    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
}

// Extract individual fields using Json Object
fun parseJsonArrayToBeneficiaryListItem(jsonArray: JSONArray): List<BeneficiaryListItem> {
    val beneficiaryList = mutableListOf<BeneficiaryListItem>()

    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        val beneficiaryListItem = BeneficiaryListItem(
            firstName = jsonObject.getString("firstName"),
            lastName = jsonObject.getString("lastName"),
            beneType = jsonObject.getString("beneType"),
            designationCode = jsonObject.getString("designationCode"),
            ssn = jsonObject.getString("socialSecurityNumber"),
            dateOfBirth = jsonObject.getString("dateOfBirth"),
            phoneNumber = jsonObject.getString("phoneNumber"),
            address = mapJsonObjectToAddress(jsonObject.getJSONObject("beneficiaryAddress"))
        )

        beneficiaryList.add(beneficiaryListItem)
    }

    return beneficiaryList
}

// Mapper method to extract nested json object values
fun mapJsonObjectToAddress(jsonObject: JSONObject): BeneficiaryAddress {
    val street = jsonObject.getString("firstLineMailing")
    val city = jsonObject.getString("city")
    val zipcode = jsonObject.getString("zipCode")
    val state = jsonObject.getString("stateCode")
    val country = jsonObject.getString("country")
    return BeneficiaryAddress(street, city, zipcode, state, country)
}


