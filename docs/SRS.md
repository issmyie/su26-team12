
# Requirements – Starter Template

**Project Name:** StudySpace

**Team:** - Eman – Provider (Tutor)<br>
          - Abdullah Khan – Customer (Student)<br>
          - Shafath – System Administrator

**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-07-02

---

## 1. Overview
**Vision.** StudySpace is a tutoring platform designed to help students connect with tutors. Students can manage their profiles, access study resources, schedule tutoring appointments, and leave reviews. Tutors and system administrators have their own dashboards to manage tutoring services and users.


**Glossary** Terms used in the project
- **Term 1:** A user who receives tutoring and uses study resources.
- **Term 2:** A user who provides tutoring services and manages appointments.

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** —Manage a profile, access study resources, book tutoring appointments, and leave reviews.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.
- **SysAdmin (optional)** — 1 line goal statement.

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
- **US‑30 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑31 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

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