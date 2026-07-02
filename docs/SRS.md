
# Requirements – Starter Template

**Project Name:** StudySpace

**Team:** - Eman – Provider (Tutor)<br>
          - Abdullah Khan – Customer (Student)<br>
          - Shafath – System Administrator<br>

**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-07-02

---

## 1. Overview
**Vision.** StudySpace is a tutoring platform designed to help students connect with tutors. Students can manage their profiles, access study resources, schedule tutoring appointments, and leave reviews. Tutors and system administrators have their own dashboards to manage tutoring services and users.


**Glossary** Terms used in the project
- **Student:** Person receiving tutoring services and study resources. 
- **System Admin:** Admins are in control of the system and manage services. 
- **Tutor:** Person providing tutoring services and study resources
- **Profile:** A collection of information about a user, including grade level and subjects of interest
- **Tutoring Session:** Meeting between tutors and students to help students with specific learning outcomes and requests.
- **Study Resources** Study guides and practice problems provided by tutors for students to use.

**Primary Users / Roles.**
 **Customer (Students)** Students can create an account, access study guides and find a tutor.
- **Provider (Tutors (TA's and Lab assistants))** Tutors can create an account, post study guides and tutor.
- **SysAdmin** — Admins can moderate the platform and ensure appropriate usage and behaviors. 

**Scope (this semester).**
- Student, Tutor, and System Administrator prototypes
- User profile management
- Study resources, appointments, and reviews

**Out of scope (deferred).**
- Online payment processing
- Video tutoring sessions


> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑1 — Manage Student Profile**  
  _Story:_ As a student, I want to manage my profile so that I can keep my personal and academic information up to date. 
 
  _Acceptance:_
  ```gherkin
  Scenario: View and update profile
    Given I am logged into the system
    When  I open my profile page
    Then  I can view and update my profile information
  ```

- **US‑2 — View Study Resources**  
  _Story:_ As a student, I want to view study resources so that I can access helpful learning materials.
  _Acceptance:_
  ```gherkin
  Scenario: Browse resources
    Given I am logged into the system
    When  I open the Resources page
    Then  available study resources are displayed
  ```

- **US-3 — Book and Cancel Appointments**  
  _Story:_ As a student, I want to book and cancel tutoring appointments so that I can manage my tutoring schedule.  

  _Acceptance:_
  ```gherkin
  Scenario: Manage appointments
    Given I am logged into the system
    When I book or cancel a tutoring appointment
    Then my appointment list is updated
  ```
- **US-4 — Leave Reviews**  
  _Story:_ As a student, I want to leave reviews after tutoring sessions so that I can provide feedback to tutors.  

  _Acceptance:_
  ```gherkin
  Scenario: Submit a review
    Given I have completed a tutoring session
    When I submit a rating and review
    Then my review is displayed in the Reviews page
  ```
### 2.2 Provider Stories
- **US-20 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US-21 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US-30 — View Platform User Data**
  Story: As a sysadmin, I want to view student and tutor account information so that I can monitor platform activity and help manage users.
  Acceptance:
  ```gherkin
  Scenario: Sysadmin views user data from the dashboard
  Given the sysadmin is logged into the StudySpace system
  When the sysadmin opens the admin dashboard
  Then the system displays a list of users with basic account information
  

- **US-31 — Manage User Access**
  Story: As a sysadmin, I want to manage user access so that I can help keep the system organized and secure.
  Acceptance:
  ```gherkin
  Scenario: Sysadmin updates a user's access level
  Given the sysadmin is logged into the StudySpace system
  When the sysadmin selects a user and changes the user's access level
  Then the system updates the user's role and shows a confirmation message
  
---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance: The main pages should load in less than 3 seconds on a normal internet connection**
- **Availability/Reliability: The prototype should be available through the GitHub repository and should open without broken page links.**
- **Security/Privacy: Only the sysadmin role should have access to admin dashboard features in the final system. Private user information should not be shown publicly.**
- **Usability: The website should be easy to read, use clear labels, and allow users to reach important pages from the navigation menu.**

---

## 4. Assumptions, Constraints, and Policies
- The project is a course prototype and does not need to be a fully finished production system.
- The high-fidelity prototype may use static HTML, CSS, and JavaScript before the backend is fully connected.
- Student, tutor, and sysadmin roles are expected to have different views.
- User stories should be tracked through GitHub issues.
- Major project changes should be discussed by the team before being added.
- The system should avoid displaying sensitive personal information unless it is required for the user role.

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues. 
- **M2 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M3 Design** — architecture, schema, API outline. 
- **M4 Backend API** — key endpoints + tests. 
- **M5 Increment** — ≥2 use cases end‑to‑end. 
- **M6 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.