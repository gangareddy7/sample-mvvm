package com.empower.retirement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.empower.retirement.models.BeneficiaryListItem
import com.empower.retirement.repository.BeneficiaryRepo
import com.empower.retirement.repository.BeneficiaryRepoImpl

class BeneficiaryViewModel: ViewModel() {

    private var repository: BeneficiaryRepo = BeneficiaryRepoImpl()

    private val _list = MutableLiveData<List<BeneficiaryListItem>>()

    val list: LiveData<List<BeneficiaryListItem>> = _list

    init {
       _list.value = repository.getBeneficiaryList()
    }

    fun getSelectionItem(selectedPosition: Int): BeneficiaryListItem? {
        return _list.value?.get(selectedPosition)
    }
}