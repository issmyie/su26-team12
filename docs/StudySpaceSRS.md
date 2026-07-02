
# Requirements – Starter Template

**Project Name:** StudySpace \
**Team:** Eman Dweik (Producer) Shafath Moreano (System Admin) Abdullah Khan (Customer)\
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-06-25

---

## 1. Overview
**Vision.** University students can find Campus-aligned tutoring from official helpers. The system allows tutors to sign up, choose their areas of expertise, and post study resources. Students can sign up, choose the subjects that they need help with, and access the resources. Admins moderate the platform to ensure that tutors and students behave appropriately and that the platform runs as planned. 

**Glossary** Terms used in the project
- **Student:** Person receiving tutoring services and study resources. 
- **System Admin:** Admins are in control of the system and manage services. 
- **Tutor:** Person providing tutoring services and study resources
- **Profile:** A collection of information about a user, including grade level and subjects of interest
- **Tutoring Session:** Meeting between tutors and students to help students with specific learning outcomes and requests.
- **Study Resources** Study guides and practice problems provided by tutors for students to use.

**Primary Users / Roles.**
- **Customer (Students)** Students can create an account, access study guides and find a tutor.
- **Provider (Tutors (TA's and Lab assistants))** Tutors can create an account, post study guides and tutor.
- **SysAdmin** — Admins can moderate the platform and ensure appropriate usage and behaviors. 

**Scope (this semester).**
- User profiles
- Booking and canceling tutoring sessions
- Viewing booking and user statistics 

**Out of scope (deferred).**
- Private messages between tutors and students. 
- Tailored learning plans and tracked student outcomes. 

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑1 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑2 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
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
