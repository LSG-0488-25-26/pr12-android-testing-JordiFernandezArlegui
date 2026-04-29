# DAM2 0488 - Desenvolupament d'interfícies
## Android Testing: Unit Testing + Instrumental Testing UI

Descripcio del Projecte

Aquest projecte consisteix en una aplicacio Android desenvolupada amb Kotlin i Jetpack Compose que segueix l'arquitectura MVVM (Model-View-ViewModel). L'aplicacio implementa diversos components d'interficie d'usuari com switch per activar desactivar Wi-Fi, checkboxes per seleccionar tipus de dieta (carnivor, vegetaria, vega), tristate checkbox, radiobuttons per seleccionar jugador, slider per controlar volum, dropdown menu per seleccionar opcions, camp de cerca amb boto i toggle button que canvia de color.

Arquitectura

L'aplicacio segueix el patro MVVM:
- Model: Gestionat per LiveData al ViewModel
- View: Composables de Jetpack Compose a MainView.kt
- ViewModel: MainViewModel.kt que conte tota la logica de negoci

Tests Implementats

Unit Tests (MainViewModelTest.kt)

S'han implementat 14 tests unitaris que cobreixen tots els metodes del ViewModel:

testInitialValues - Verifica els valors inicials de totes les LiveData
testToggleEstatSwitch - Prova el canvi d'estat del Switch Wi-Fi
testToggleEsVegetaria - Prova el canvi d'estat del Checkbox Vegetaria
testToggleEsVega - Prova el canvi d'estat del Checkbox Vega
testToggleEsCarnivor - Prova el canvi d'estat del Checkbox Carnivor
testToggleTriStateStatus - Prova el cicle d'estats del TriState (Off, Indeterminate, On)
testSetSelectedOption - Prova el canvi de seleccio dels RadioButtons
testSetSliderValue - Prova el canvi de valor del Slider
testSetExpanded - Prova l'estat expandit del Dropdown
testSetSelectedItem - Prova la seleccio d'items del Dropdown
testSetSearchText - Prova l'entrada de text al camp de cerca
testPerformSearch_withEmptyText_doesNotShowSnackbar - Prova la cerca amb text buit
testToggle_initialValueIsFalse - Verifica l'estat inicial del Toggle Button
testShowSnackbar_initialValueIsFalse - Verifica l'estat inicial del Snackbar

UI Tests (MainViewTest.kt)

S'han implementat 7 tests instrumentals que cobreixen tots els composables:

mainViewShowsAllComponents - Verifica que tots els components UI existeixen
switchAndCheckboxesReactToClicks - Prova la interaccio amb Switch i Checkboxes
radioButtonsReactToClicks - Prova la interaccio amb RadioButtons
sliderExistsAndCanBeInteracted - Prova que el Slider existeix i es pot interactuar
dropdownAnchorExistsAndIsClickable - Prova que l'anchor del Dropdown es clickable
searchFieldAndButtonWork - Prova el camp de cerca i el boto
toggleButtonExistsAndIsClickable - Prova que el Toggle Button existeix i es clickable

Captura de Pantalla

<img width="902" height="309" alt="image" src="https://github.com/user-attachments/assets/3ce8c7f2-52fd-469e-a73b-abe1dab126bd" />


Aplicacio en funcionament
Ok

Unit Tests - Resultats
Ok

UI Tests - Resultats
Ok

Execucio UI Tests en dispositiu real
Ok

Video d'Execucio dels Tests

https://github.com/user-attachments/assets/7ec4006b-d9c8-4c67-819e-e11327ec36b6

Tecnologies Utilitzades


Dependencies Principals

Core:
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

Compose:
implementation(platform("androidx.compose:compose-bom:2024.02.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")

Testing:
testImplementation("junit:junit:4.13.2")
testImplementation("androidx.arch.core:core-testing:2.2.0")
testImplementation("org.robolectric:robolectric:4.11.1")
androidTestImplementation("androidx.compose.ui:ui-test-junit4")

Com Executar els Tests

Unit Tests:
./gradlew testDebugUnitTest

UI Tests (Instrumentals):
./gradlew connectedDebugAndroidTest

Des d'Android Studio:
1. Fer clic dret a la classe MainViewModelTest i seleccionar Run
2. Fer clic dret a la classe MainViewTest i seleccionar Run

Resultats dels Tests

Unit Tests: 14 passed, 0 failed
UI Tests: 7 passed, 0 failed

Autor

Jordi Fernandez Arlegui
DAM2 - Desenvolupament d'Interfacies
29 Abril 2026
