# PhysioAssistant Development Guide
## Table of Contents
- [Introduction](#introduction)
- [File Structure](#file-structure)
- [Activities](#activities)
  - [LoginActivity](#loginactivity)
  - [MainActivity](#mainactivity)
  - [SplashActivity](#splashactivity)
  - [AdminActivity](#adminactivity)
  - [DoctorActivity](#doctoractivity)
  - [PatientActivity](#patientactivity)
- [Resources](#resources)
  - [Logo](#logo)
  - [Colors](#colors)
  - [Strings](#strings)

## Introduction
This guide will help the development team to build an Android application for a physiotherapy center. The application will have three types of users: Admin, Doctor, and Patient. The Admin will be responsible for creating the physiotherapy center and adding new services, the Doctor will have access to the patient history, appointment plan, and appointment requests, and the Patient will be able to request appointments and view financial transactions.

## File Structure
Refer to: [file-structure.md](https://github.com/Android-Development-UoM/PhysioAssistant-FrontEnd/blob/main/docs/file-structure.md)
## Activities

### LoginActivity
The `LoginActivity` activity will be used for the login process.

### SplashActivity
The `SplashActivity` activity is a simple splash screen activity.

### AdminActivity
The `AdminActivity` activity is the home activity for the admin user.

### DoctorActivity
The `DoctorActivity` activity is the home activity for the doctor user.

### PatientActivity
The `PatientActivity` activity is the home activity for the patient user. 

## Resources
### Logo
The logo for the PhysioAssistant app is located in:
```
res/drawable/logo_white.png
```

### Colors
The app's color scheme is defined in the `colors.xml` file located in the `values` folder. The colors can be referenced using their respective color names. \

### Strings
The text strings used in each activity are located in separate `.xml` files in the `values` folder. For example, the strings used in the `MainActivity` activity are located in the `strings_main.xml` file. Similarly, the strings used in the `CreateServiceActivity` activity are located in the `strings_create_service.xml` file.
