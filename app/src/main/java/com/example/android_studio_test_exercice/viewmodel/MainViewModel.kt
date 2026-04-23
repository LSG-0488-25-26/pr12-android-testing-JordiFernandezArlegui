package com.example.android_studio_test_exercice.viewmodel

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Existing attributes
    private val _estatSwitch = MutableLiveData(true)
    val estatSwitch: LiveData<Boolean> = _estatSwitch

    private val _esVegetaria = MutableLiveData(false)
    val esVegetaria: LiveData<Boolean> = _esVegetaria

    private val _esVega = MutableLiveData(false)
    val esVega: LiveData<Boolean> = _esVega

    private val _esCarnivor = MutableLiveData(true)
    val esCarnivor: LiveData<Boolean> = _esCarnivor

    private val _triStateStatus = MutableLiveData(ToggleableState.Off)
    val triStateStatus: LiveData<ToggleableState> = _triStateStatus

    private val _selectedOption = MutableLiveData("Messi")
    val selectedOption: LiveData<String> = _selectedOption

    // New attributes for MainView
    private val _sliderValue = MutableLiveData(0f)
    val sliderValue: LiveData<Float> = _sliderValue

    private val _expanded = MutableLiveData(false)
    val expanded: LiveData<Boolean> = _expanded

    private val _selectedItem = MutableLiveData("Opció A")
    val selectedItem: LiveData<String> = _selectedItem

    private val _searchText = MutableLiveData("")
    val searchText: LiveData<String> = _searchText

    private val _showSnackbar = MutableLiveData(false)
    val showSnackbar: LiveData<Boolean> = _showSnackbar

    private val _toggleState = MutableLiveData(false)
    val toggleState: LiveData<Boolean> = _toggleState

    // Existing methods
    fun toggleEstatSwitch() {
        _estatSwitch.value = _estatSwitch.value?.not()
    }

    fun toggleEsCarnivor() {
        _esCarnivor.value = _esCarnivor.value?.not()
    }

    fun toggleTriStateStatus() {
        _triStateStatus.value = when (_triStateStatus.value) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
            null -> ToggleableState.On
        }
    }

    // New methods for MainView
    fun toggleEsVegetaria() {
        _esVegetaria.value = _esVegetaria.value?.not()
    }

    fun toggleEsVega() {
        _esVega.value = _esVega.value?.not()
    }

    fun setSelectedOption(option: String) {
        _selectedOption.value = option
    }

    fun setSliderValue(value: Float) {
        _sliderValue.value = value
    }

    fun setExpanded(value: Boolean) {
        _expanded.value = value
    }

    fun setSelectedItem(item: String) {
        _selectedItem.value = item
    }

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun performSearch() {
        val query = _searchText.value
        if (!query.isNullOrEmpty()) {
            _showSnackbar.value = true
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                _showSnackbar.value = false
            }, 2000)
        }
    }

    fun toggle() {
        _toggleState.value = _toggleState.value?.not()
        _showSnackbar.value = true
        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
            _showSnackbar.value = false
        }, 2000)
    }
}