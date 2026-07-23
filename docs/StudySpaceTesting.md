**Project Name:**   StudySpace
**Version:** 1.0
**Date:**  07/22/2026
**Purpose:** Test plan for the StudySpace application

## Actors
- Provider P: Eman Dweik
- Customer C: Student using StudySpace
- Service S: Shafath Moreano

## Use Cases
#### 1. Customer: US‑CUST‑001 — Register & manage profile
1. Customer C1 logs in for the first time and creates a profile.
2. C1 edits their profile to update personal information and preferences.
3. C1 saves the changes.
4. Updated profile information is displayed correctly.

### 2. Customer: US-CUST-002 — Book and Manage Appointments
1. Customer C1 logs in.
2. C1 navigates to the Appointments page.
3. C1 books a tutoring appointment for a selected course and tutor.
4. The appointment is saved and displayed in the appointment list.
5. C1 cancels the appointment if necessary.

### 3. Customer: US-CUST-003 — Browse Study Resources
1. Customer C1 logs in.
2. C1 opens the Resources page.
3. C1 browses the available study materials.
4. C1 selects a resource to view.

### 4. Customer: US-CUST-004 — Submit Reviews
1. Customer C1 logs in.
2. C1 opens the Reviews page.
3. C1 submits a review and rating.
4. The review is saved and displayed.

#### 6. Provider: 
1.
2.

#### 7. Provider: 
1.
2.

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Customer dashboard loads within 2 seconds**
- **Setup:** Server under normal load.
- **Steps:**
  1. Customer logs in.
  2. Opens the Dashboard.
  3. Repeat 10 times.
- **Expected Outcome:** 95% of requests within 2 seconds.

**Scenario P2: Resources page loads within 2 seconds**
- **Setup:** Server under normal load.
- **Steps:** 
  1. Customer opens the Resources page.
  2.  Repeat 10 times.
- **Expected Outcome:** 95% of page requests load within 2 seconds. 

### Security & Privacy Requirements

**Scenario S1: Customer can access only their own information.**
- **Setup:** Customer is logged in. 
- **Steps:**
  1. Customer opens Profile, Appointments, and Reviews.
  2. Attempts to access another customer's information.
- **Expected Outcome:** Access is denied and only the logged-in customer's information is displayed.

**Scenario S2: Invalid appointment submission is rejected**
- **Setup:** Customer is logged in.
- **Steps:**
  1. Customer submits an appointment with missing required fields.
- **Expected Outcome:** Validation message is displayed and no appointment is saved.

### Usability Requirements

**Scenario U1: Customer navigates between all customer pages successfully**
- **Setup:** Customer is logged in.
- **Steps:**
  1. Open Dashboard.
  2. Navigate to Profile.
  3. Navigate to Resources.
  4. Navigate to Appointments.
  5. Navigate to Reviews.
- **Expected Outcome:** All pages load successfully and navigation works without errors.

**Scenario U2: Customer books an appointment within 3 minutes**
- **Setup:** New customer account.
- **Steps:**
  1. Customer logs in.
  2. Opens Appointments.
  3. Books an appointment.
  4. Confirms the booking.
- **Expected Outcome:** Appointment is successfully booked within 3 minutes.
