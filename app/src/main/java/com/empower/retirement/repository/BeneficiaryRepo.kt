package com.empower.retirement.repository

import com.empower.retirement.models.BeneficiaryListItem

interface BeneficiaryRepo {
    fun getBeneficiaryList(): List<BeneficiaryListItem>
}