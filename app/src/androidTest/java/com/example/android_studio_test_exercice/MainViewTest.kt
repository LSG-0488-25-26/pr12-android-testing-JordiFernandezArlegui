package com.example.android_studio_test_exercice.view

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun setMainViewContent(): MainViewModel {
        val viewModel = MainViewModel()

        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        return viewModel
    }

    @Test
    fun mainViewShowsAllComponents() {
        setMainViewContent()

        // Verificar componentes principales
        composeTestRule.onNodeWithText("Activar Wi-Fi:").assertExists()
        composeTestRule.onNodeWithText("Opcions de menu:").assertExists()
        composeTestRule.onNodeWithText("Carnivor/a").assertExists()
        composeTestRule.onNodeWithText("Vegetaria/na").assertExists()
        composeTestRule.onNodeWithText("Vega/na").assertExists()
        composeTestRule.onNodeWithTag("tristate_checkbox").assertExists()
        composeTestRule.onNodeWithText("Pilota d'Or:").assertExists()
        composeTestRule.onNodeWithText("Vinicius").assertExists()
        composeTestRule.onNodeWithText("Lamine Yamal").assertExists()
        composeTestRule.onNodeWithText("Raphina").assertExists()
        composeTestRule.onNodeWithTag("dropdown_anchor").assertExists()
        composeTestRule.onNodeWithText("Buscar...").assertExists()
        composeTestRule.onNodeWithText("Buscar").assertExists()
        composeTestRule.onNodeWithTag("toggle_button").assertExists()
    }

    @Test
    fun switchAndCheckboxesReactToClicks() {
        setMainViewContent()

        // Test Switch
        composeTestRule.onNodeWithTag("wifi_switch").assertIsOn().performClick()
        composeTestRule.onNodeWithTag("wifi_switch").assertIsOff()

        // Test Checkboxes
        composeTestRule.onNodeWithTag("carnivor_checkbox").assertIsOn().assertIsNotEnabled()

        composeTestRule.onNodeWithTag("vegetaria_checkbox").assertIsOff().assertIsEnabled().performClick()
        composeTestRule.onNodeWithTag("vegetaria_checkbox").assertIsOn()

        composeTestRule.onNodeWithTag("vega_checkbox").assertIsOff().assertIsEnabled().performClick()
        composeTestRule.onNodeWithTag("vega_checkbox").assertIsOn()
    }

    @Test
    fun radioButtonsReactToClicks() {
        setMainViewContent()

        composeTestRule.onNodeWithTag("radio_Vinicius").assertIsNotEnabled()
        composeTestRule.onNodeWithTag("radio_Lamine_Yamal").performClick().assertIsSelected()
        composeTestRule.onNodeWithTag("radio_Raphina").performClick().assertIsSelected()
    }

    @Test
    fun sliderExistsAndCanBeInteracted() {
        setMainViewContent()

        composeTestRule.onNodeWithTag("volume_slider").performTouchInput {
            swipeLeft()
        }

        // Verificar que el texto del volumen existe
        composeTestRule.onNodeWithText("Volum:", substring = true).assertExists()
    }

    @Test
    fun dropdownAnchorExistsAndIsClickable() {
        setMainViewContent()

        // Verificar que el anchor del dropdown existe y se puede hacer clic
        composeTestRule.onNodeWithTag("dropdown_anchor").assertExists().performClick()
        // Hacer clic de nuevo para cerrar
        composeTestRule.onNodeWithTag("dropdown_anchor").performClick()
    }

    @Test
    fun searchFieldAndButtonWork() {
        setMainViewContent()

        composeTestRule.onNodeWithTag("search_text_field").performTextInput("test")
        composeTestRule.onNodeWithTag("search_button").performClick()
    }

    @Test
    fun toggleButtonExistsAndIsClickable() {
        setMainViewContent()

        composeTestRule.onNodeWithTag("toggle_button").performClick()
        composeTestRule.onNodeWithTag("toggle_button").performClick()
    }
}