package com.example.android_studio_test_exercice.view

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testWiFiSwitchIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Activar Wi-Fi:").assertIsDisplayed()
    }

    @Test
    fun testMenuOptionsAreDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Opcions de menú:").assertIsDisplayed()
        composeTestRule.onNodeWithText("Carnívor/a").assertIsDisplayed()
        composeTestRule.onNodeWithText("Vegetarià/na").assertIsDisplayed()
        composeTestRule.onNodeWithText("Vegà/na").assertIsDisplayed()
    }

    @Test
    fun testTriStateCheckboxIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("TriState").assertIsDisplayed()
    }

    @Test
    fun testRadioButtonsAreDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Pilota d'Or:").assertIsDisplayed()
        composeTestRule.onNodeWithText("Vinicius").assertIsDisplayed()
        composeTestRule.onNodeWithText("Lamine Yamal").assertIsDisplayed()
        composeTestRule.onNodeWithText("Raphina").assertIsDisplayed()
    }

    @Test
    fun testSliderIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Volum: 0%").assertIsDisplayed()
    }

    @Test
    fun testDropdownMenuIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Opció A").assertIsDisplayed()
    }

    @Test
    fun testSearchFieldIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Buscar...").assertIsDisplayed()
    }

    @Test
    fun testSearchButtonIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Buscar").assertIsDisplayed()
    }

    @Test
    fun testToggleButtonIsDisplayed() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Desactivat").assertIsDisplayed()
    }

    @Test
    fun testVegetarianCheckboxCanBeClicked() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Vegetarià/na").assertIsDisplayed()
    }

    @Test
    fun testVeganCheckboxCanBeClicked() {
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Vegà/na").assertIsDisplayed()
    }
}