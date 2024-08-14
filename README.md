# Android MVVM Architecture Sample Project

This project demonstrates the implementation of the Model-View-ViewModel (MVVM) architecture pattern in an Android application. The app is a simple example where users can interact with a `ListView` displaying account holders beneficiary information. The UI is created programmatically without XML layout files.

## Project Structure

- **Model**: Represents the data. In this example, it's a simple `BeneficiaryListItem` data class.
- **View**: The UI components. In this example, the `Activity` is used to create and manage the UI programmatically.
- **ViewModel**: Handles the logic and data for the view. It interacts with the model and exposes data to the view.

## Getting Started

### Prerequisites

- Android Studio
- JDK 8 or higher
- Basic understanding of Android development and MVVM architecture

### Clone the Repository

```bash
git clone https://github.com/gangareddy7/sample-mvvm.git
cd sample-mvvm
```


### Open the Project

1. Open Android Studio.
2. Click on `Open an Existing Project`.
3. Navigate to the cloned project directory and select it.

### Build and Run

1. Ensure you have an Android emulator running or a physical device connected.
2. Click on the `Run` button in Android Studio.

### Project Overview

#### Model

`BeneficiaryListItem.kt`:
```kotlin
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
```

- Represents BeneficiaryListItem data with multiple properties.

#### ViewModel

`BeneficiaryViewModel.kt`:
```kotlin
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
```

- Manages beneficiary data and provides methods to display account holders information in the list.

#### View

`BeneficiaryListActivity.kt`:
```kotlin
class BeneficiaryListActivity : BaseActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: BeneficiaryCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, BeneficiaryDetailsActivity::class.java)
            intent.putExtra("index", position)
            startActivity(intent)
        }

        // Set the ListView as the content view of the Activity
        setContentView(listView)

    }

    private fun init() {
        listView = ListView(this)
        adapter = BeneficiaryCustomAdapter(this)
        listView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        // Observe the items from the ViewModel
        viewModel.list.observe(this) {
            adapter.populateData(it)
        }
    }
}
```

- Manages UI creation and updates. Observes changes in the `ViewModel` and updates the `ListView`.

## Dependencies

- AndroidX Libraries
- ViewModel
- LiveData
- Json

Ensure your `build.gradle` files include the necessary dependencies for ViewModel and LiveData.

