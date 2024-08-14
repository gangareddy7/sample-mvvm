package com.empower.retirement.models


data class BeneficiaryListItem(
    val firstName: String,
    val lastName: String,
    val beneType: String,
    val designationCode: String,
    val ssn: String,
    val dateOfBirth: String,
    val phoneNumber: String,
    val address: BeneficiaryAddress
)


data class BeneficiaryAddress(
    val streetName: String,
    val city: String,
    val zipCode: String,
    val stateCode: String,
    val country: String
)