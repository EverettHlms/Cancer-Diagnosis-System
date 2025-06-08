# Cancer Diagnosis Expert System

**Author:** Everett Holmes
**Project Date:** Spring 2025

## Overview

This project is a command-line expert system designed to provide a potential cancer diagnosis based on user-provided symptoms. It uses a predefined knowledge base of rules to match symptoms to various types of cancer and suggests a possible course of treatment. The entire interaction occurs through a command-line interface.

## How to Run

To run this application, follow these steps:

1.  Open the `CancerDiagnosisSystem.java` file in a Java-compatible IDE like VSCode.
2.  Run the code to start the program, which uses the command-line interface within the terminal.
3.  The system will first prompt you with initial questions about whether you suspect cancer and your gender (Male or Female).
4.  The system will then prompt you with specific symptoms; respond with `Yes` for any symptoms you are experiencing.
5.  If you have no more symptoms to report, enter `Done` to finalize your input.
6.  The system will then display the diagnosis and other information in a table format.
7.  To run another diagnosis, simply re-run the program.

## Features

* **Rule-Based Inference Engine**: Uses a set of predefined rules to derive conclusions from user input.
* **Gender-Specific Logic**: Provides different sets of questions for male and female users.
* **Interactive CLI**: All interactions are handled through a simple command-line interface.
* **Provides Diagnosis and Treatment**: The system diagnoses a potential cancer and suggests a course of treatment based on your symptoms.
* **Traceability**: Outputs the internal rule and clause numbers it used to reach the conclusion.
* **Knowledge Base**: Contains rules and variables for diagnosing 14 different types of cancer.
* **Formatted Output**: Presents the final diagnosis, treatment, and the list of derived variables (your symptoms) in a clean table format.

---

**Disclaimer:** This is an academic project created for educational purposes. It is **NOT** a substitute for professional medical advice, diagnosis, or treatment. Always seek the advice of your physician or other qualified health provider with any questions you may have regarding a medical condition.
