package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    // Tests per toggleEstatSwitch
    @Test
    fun testToggleEstatSwitch_initialValueIsTrue() {
        val initialValue = viewModel.estatSwitch.value
        assertEquals(true, initialValue)
    }

    @Test
    fun testToggleEstatSwitch_changesValue() {
        viewModel.toggleEstatSwitch()
        assertEquals(false, viewModel.estatSwitch.value)

        viewModel.toggleEstatSwitch()
        assertEquals(true, viewModel.estatSwitch.value)
    }

    // Tests per toggleEsCarnivor
    @Test
    fun testToggleEsCarnivor_initialValueIsTrue() {
        assertEquals(true, viewModel.esCarnivor.value)
    }

    @Test
    fun testToggleEsCarnivor_changesValue() {
        viewModel.toggleEsCarnivor()
        assertEquals(false, viewModel.esCarnivor.value)

        viewModel.toggleEsCarnivor()
        assertEquals(true, viewModel.esCarnivor.value)
    }

    // Tests per toggleTriStateStatus
    @Test
    fun testToggleTriStateStatus_initialStateIsOff() {
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    @Test
    fun testToggleTriStateStatus_cyclesThroughStates() {
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    // Tests per toggleEsVegetaria
    @Test
    fun testToggleEsVegetaria_initialValueIsFalse() {
        assertEquals(false, viewModel.esVegetaria.value)
    }

    @Test
    fun testToggleEsVegetaria_changesValue() {
        viewModel.toggleEsVegetaria()
        assertEquals(true, viewModel.esVegetaria.value)

        viewModel.toggleEsVegetaria()
        assertEquals(false, viewModel.esVegetaria.value)
    }

    // Tests per toggleEsVega
    @Test
    fun testToggleEsVega_initialValueIsFalse() {
        assertEquals(false, viewModel.esVega.value)
    }

    @Test
    fun testToggleEsVega_changesValue() {
        viewModel.toggleEsVega()
        assertEquals(true, viewModel.esVega.value)

        viewModel.toggleEsVega()
        assertEquals(false, viewModel.esVega.value)
    }

    // Tests per setSelectedOption
    @Test
    fun testSetSelectedOption_initialValueIsMessi() {
        assertEquals("Messi", viewModel.selectedOption.value)
    }

    @Test
    fun testSetSelectedOption_updatesValue() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)

        viewModel.setSelectedOption("Raphina")
        assertEquals("Raphina", viewModel.selectedOption.value)
    }

    // Tests per setSliderValue
    @Test
    fun testSetSliderValue_initialValueIsZero() {
        assertEquals(0f, viewModel.sliderValue.value)
    }

    @Test
    fun testSetSliderValue_updatesValue() {
        viewModel.setSliderValue(50f)
        assertEquals(50f, viewModel.sliderValue.value)

        viewModel.setSliderValue(100f)
        assertEquals(100f, viewModel.sliderValue.value)
    }

    // Tests per setExpanded
    @Test
    fun testSetExpanded_updatesValue() {
        viewModel.setExpanded(true)
        assertEquals(true, viewModel.expanded.value)

        viewModel.setExpanded(false)
        assertEquals(false, viewModel.expanded.value)
    }

    // Tests per setSelectedItem
    @Test
    fun testSetSelectedItem_initialValueIsOpcioA() {
        assertEquals("Opció A", viewModel.selectedItem.value)
    }

    @Test
    fun testSetSelectedItem_updatesValue() {
        viewModel.setSelectedItem("Opció B")
        assertEquals("Opció B", viewModel.selectedItem.value)

        viewModel.setSelectedItem("Opció C")
        assertEquals("Opció C", viewModel.selectedItem.value)
    }

    // Tests per setSearchText
    @Test
    fun testSetSearchText_initialValueIsEmpty() {
        assertEquals("", viewModel.searchText.value)
    }

    @Test
    fun testSetSearchText_updatesValue() {
        viewModel.setSearchText("Android")
        assertEquals("Android", viewModel.searchText.value)
    }

    // Tests per performSearch
    @Test
    fun testPerformSearch_withEmptyText_doesNotShowSnackbar() {
        viewModel.setSearchText("")
        viewModel.performSearch()
        assertFalse(viewModel.showSnackbar.value ?: false)
    }

    // Tests per toggle (només valors inicials, sense cridar toggle)
    @Test
    fun testToggle_initialValueIsFalse() {
        assertEquals(false, viewModel.toggleState.value)
    }

    @Test
    fun testShowSnackbar_initialValueIsFalse() {
        assertEquals(false, viewModel.showSnackbar.value ?: false)
    }
}