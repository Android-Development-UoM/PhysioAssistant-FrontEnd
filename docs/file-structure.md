# File Structure
## Description
This is the original file structure of the PhysioAssistant project. It organizes the codebase into various directories and files, grouped by functionality and user roles. Here's a brief overview of each component:

- **activities**: Contains activities for different user roles (admin, doctor, login, patient).
- **adapters**: Contains adapter classes for displaying data in various contexts.
- **backend**: Contains API interfaces, data managers, events, requests/responses, and Retrofit configuration for the backend.
- **listeners**: Contains listener classes for handling events like drop-down clicks and back button presses.
- **models**: Contains model classes representing different entities in the application (appointments, users, physio actions).
- **ui**: Contains common utility classes, dropdown-related classes, fragments for different user roles and functionalities, and navigation components.
- **MainActivity**: Represents the main entry point of the application (It is the Splash Screen).

## Usage
The PhysioAssistant project is structured to provide an organized and modular codebase. Each directory represents a specific aspect of the application, and the files within them contain the relevant code. You can navigate through the project structure to find the specific components you need.

## Tree Representation
```
/
└── uom.android.physioassistant
    ├── activities
    │   ├── admin
    │   │   └── AdminActivity
    │   ├── doctor
    │   │   └── DoctorActivity
    │   ├── login
    │   │   └── LoginActivity
    │   └── patient
    │       └── PatientActivity
    ├── adapters
    │   ├── AppointmentAdapter
    │   ├── DoctorAdapter
    │   ├── DoctorAppointmentAdapter
    │   ├── IDropDownAdapter
    │   ├── NotificationAdapter
    │   ├── PatientAdapter
    │   ├── PatientDropdownAdapter
    │   ├── ServiceAdapter
    │   ├── ServiceDropDownAdapterAdapter
    │   └── TimeAdapter
    ├── backend
    │   ├── api
    │   │   ├── AppointmentApi
    │   │   ├── AuthenticationApi
    │   │   ├── DoctorApi
    │   │   ├── PatientApi
    │   │   └── PhysioActionApi
    │   ├── datamanager
    │   │   └── DataManager
    │   ├── events
    │   │   ├── AppointmentCreatedEvent
    │   │   ├── AppointmentsLoadedEvent
    │   │   ├── AppointmentUpdatedEvent
    │   │   ├── DoctorCreatedEvent
    │   │   ├── DoctorLoadedEvent
    │   │   ├── DoctorsLoadedEvent
    │   │   ├── PatientCreatedEvent
    │   │   ├── PatientLoadedEvent
    │   │   ├── PatientsLoadedEvent
    │   │   ├── PhysioActionCreatedEvent
    │   │   └── PhysioActionsLoadedEvent
    │   ├── requests
    │   │   ├── AppointmentRequest
    │   │   ├── CreateDoctorRequest
    │   │   ├── CreatePatientRequest
    │   │   └── LoginRequest
    │   ├── responses
    │   │   ├── ErrorResponse
    │   │   └── LoginResponse
    │   └── retrofit
    │       └── BackendAPI
    ├── listeners
    │   ├── DropDownClickListener
    │   └── OnBackPressedListener
    ├── models
    │   ├── appointment
    │   │   ├── comparators
    │   │   │   ├── AppointmentAscendingComp
    │   │   │   └── AppointmentDescendingComp
    │   │   ├── Appointment
    │   │   └── AppointmentStatus
    │   ├── users
    │   │   ├── admin
    │   │   │   └── Admin
    │   │   ├── doctor
    │   │   │   └── Doctor
    │   │   ├── patient
    │   │   │   └── Patient
    │   │   ├── User
    │   │   └── UserType
    │   └── PhysioAction
    ├── ui
    │   ├── common
    │   │   ├── ButtonType
    │   │   ├── ClearEditTexts
    │   │   └── FragmentType
    │   ├── dropdown
    │   │   ├── DropDown
    │   │   ├── DropDownItem
    │   │   └── DropDownManager
    │   ├── fragments
    │   │   ├── admin
    │   │   │   ├── CreateDoctorFragment
    │   │   │   └── CreateServiceFragment
    │   │   ├── doctor
    │   │   │   ├── appointment
    │   │   │   │   ├── AppointmentCalendarDoctorFragment
    │   │   │   │   ├── AppointmentOptionsDoctorFragment
    │   │   │   │   └── AppointmentSummaryDoctorFragment
    │   │   │   ├── home
    │   │   │   │   ├── DoctorCalendarFragment
    │   │   │   │   └── DoctorHomeFragment
    │   │   │   ├── notifications
    │   │   │   │   └── NotificationsFragment
    │   │   │   └── patients
    │   │   │       ├── CreatePatientFragment
    │   │   │       ├── PatientHistoryFragment
    │   │   │       └── PatientsFragment
    │   │   ├── patient
    │   │   │   ├── appointment
    │   │   │   │   ├── AppointmentCalendarFragment
    │   │   │   │   ├── AppointmentOptionsFragment
    │   │   │   │   └── AppointmentSummary
    │   │   │   ├── home
    │   │   │   │   ├── PatientCalendarFragment
    │   │   │   │   └── PatientHomeFragment
    │   │   │   ├── services
    │   │   │   └── ServiceFragment
    │   │   └── FragmentNavigation
    │   └── navigation
    │       ├── DoctorNavBar
    │       ├── NavBar
    │       ├── NavButton
    │       ├── NavItem
    │       └── PatientNavBar
    └── MainActivity
```
