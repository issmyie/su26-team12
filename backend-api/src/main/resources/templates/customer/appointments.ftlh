<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>StudySpace · Appointments</title>

    <link
        rel="stylesheet"
        href="/customer/appointments.css"
    >
</head>

<body>

<div class="app">

    
    <aside class="sidebar">

        <div class="sidebar-brand">
            <span class="brand-icon">📘</span>
            <span>StudySpace</span>
        </div>

        <nav class="sidebar-nav">

            <a href="/customer/dashboard/${customer.id}">
                <span class="nav-icon">📊</span>
                Dashboard
            </a>

            <a href="/customer/profile/${customer.id}">
                <span class="nav-icon">👤</span>
                Profile
            </a>

            <a href="/customer/resources">
                <span class="nav-icon">📚</span>
                Resources
            </a>

            <a
                href="/customer/appointments?customerId=${customer.id}"
                class="active"
            >
                <span class="nav-icon">📅</span>
                Appointments
            </a>

            <a href="/customer/reviews">
                <span class="nav-icon">⭐</span>
                Reviews
            </a>

        </nav>

        <div class="sidebar-footer">

            <div class="student-card">

                <div class="avatar">
                    <#if customer.name?? && customer.name?has_content>
                        ${customer.name?substring(0, 1)?upper_case}
                    <#else>
                        S
                    </#if>
                </div>

                <div>
                    <p class="student-name">
                        ${customer.name!"Student"}
                    </p>

                    <p class="student-role">
                        Student
                    </p>
                </div>

            </div>

        </div>

    </aside>

    <!-- Main content -->
    <main class="main">

        <header class="main-header">

            <div>
                <h1>Appointments</h1>

                <p class="greeting">
                    Book, view, and cancel tutoring sessions.
                </p>
            </div>

            <div class="header-actions">

                <a
                    class="btn btn-outline"
                    href="/customer/dashboard/${customer.id}"
                >
                    ← Back to Dashboard
                </a>

                <button
                    type="button"
                    class="btn btn-primary"
                    onclick="scrollToBookingForm()"
                >
                    Book New Session
                </button>

            </div>

        </header>

        
        <#if successMessage??>

            <div class="alert alert-success">
                ${successMessage}
            </div>

        </#if>

        <!-- Statistics -->
        <section class="stats-grid">

            <div class="stat-card">

                <div class="stat-label">
                    Upcoming
                </div>

                <div class="stat-number">
                    ${upcomingCount}
                </div>

                <span class="stat-change">
                    scheduled sessions
                </span>

            </div>

            <div class="stat-card">

                <div class="stat-label">
                    Completed
                </div>

                <div class="stat-number">
                    ${completedCount}
                </div>

                <span class="stat-change">
                    total sessions
                </span>

            </div>

            <div class="stat-card">

                <div class="stat-label">
                    Canceled
                </div>

                <div class="stat-number">
                    ${canceledCount}
                </div>

                <span class="stat-change">
                    canceled sessions
                </span>

            </div>

        </section>

        <div class="appointments-grid">

            
            <div class="left-col">

                <!-- Upcoming appointments -->
                <div class="card">

                    <div class="card-header">

                        <h2>📅 Upcoming Sessions</h2>

                        <span class="badge">
                            ${upcomingCount} scheduled
                        </span>

                    </div>

                    <#assign visibleAppointmentCount = 0>

                    <#list appointments as appointment>

                        <#assign appointmentStatus =
                            (appointment.status!"PENDING")?upper_case
                        >

                        <#if appointmentStatus != "CANCELED"
                            && appointmentStatus != "CANCELLED"
                            && appointmentStatus != "COMPLETED">

                            <#assign visibleAppointmentCount =
                                visibleAppointmentCount + 1
                            >

                            <div class="appointment-card">

                                <div class="appointment-details">

                                    <h3>
                                        ${appointment.course}
                                    </h3>

                                    <p>
                                        ${appointment.tutorName}
                                        ·
                                        ${appointment.appointmentDate}
                                        ·
                                        ${appointment.appointmentTime}
                                    </p>

                                    <#if appointment.notes??
                                        && appointment.notes?has_content>

                                        <p class="appointment-notes">
                                            ${appointment.notes}
                                        </p>

                                    </#if>

                                    <#if appointmentStatus == "CONFIRMED"
                                        || appointmentStatus == "SCHEDULED">

                                        <span class="status confirmed">
                                            ${appointment.status}
                                        </span>

                                    <#else>

                                        <span class="status pending">
                                            ${appointment.status!"PENDING"}
                                        </span>

                                    </#if>

                                </div>

                                <form
                                    method="post"
                                    action="/customer/appointments/cancel/${appointment.id}"
                                    onsubmit="return confirmCancel();"
                                >

                                    <input
                                        type="hidden"
                                        name="customerId"
                                        value="${customer.id}"
                                    >

                                    <button
                                        type="submit"
                                        class="btn btn-sm btn-danger"
                                    >
                                        Cancel
                                    </button>

                                </form>

                            </div>

                        </#if>

                    </#list>

                    <#if visibleAppointmentCount == 0>

                        <div class="empty-state">

                            <p>
                                No upcoming appointments found.
                            </p>

                            <button
                                type="button"
                                class="btn btn-primary"
                                onclick="scrollToBookingForm()"
                            >
                                Book Your First Session
                            </button>

                        </div>

                    </#if>

                </div>

                <!-- Available tutors -->
                <div class="card">

                    <div class="card-header">

                        <h2>👨‍🏫 Available Tutors</h2>

                        <span class="badge">
                            book a session
                        </span>

                    </div>

                    <div class="tutor-list">

                        <div class="tutor-row">

                            <div>
                                <h3>Emily Wilson</h3>

                                <p>
                                    Biology Tutor · ⭐ 4.9
                                </p>
                            </div>

                            <button
                                type="button"
                                class="btn btn-sm btn-primary"
                                onclick="selectTutor(
                                    'Biology 101',
                                    'Emily Wilson'
                                )"
                            >
                                Book
                            </button>

                        </div>

                        <div class="tutor-row">

                            <div>
                                <h3>Michael Brown</h3>

                                <p>
                                    Writing Tutor · ⭐ 4.8
                                </p>
                            </div>

                            <button
                                type="button"
                                class="btn btn-sm btn-primary"
                                onclick="selectTutor(
                                    'English Composition',
                                    'Michael Brown'
                                )"
                            >
                                Book
                            </button>

                        </div>

                        <div class="tutor-row">

                            <div>
                                <h3>Sophia Lee</h3>

                                <p>
                                    Calculus Tutor · ⭐ 4.7
                                </p>
                            </div>

                            <button
                                type="button"
                                class="btn btn-sm btn-primary"
                                onclick="selectTutor(
                                    'Calculus I',
                                    'Sophia Lee'
                                )"
                            >
                                Book
                            </button>

                        </div>

                    </div>

                </div>

            </div>

            
            <div class="right-col">

                <div
                    class="card"
                    id="booking-form"
                >

                    <div class="card-header">

                        <h2>📝 Book a Session</h2>

                        <span class="badge">
                            request form
                        </span>

                    </div>

                    <form
                        method="post"
                        action="/customer/appointments/book"
                    >

                        <input
                            type="hidden"
                            name="customerId"
                            value="${customer.id}"
                        >

                        <div class="form-group">

                            <label for="course">
                                Course
                            </label>

                            <select
                                id="course"
                                name="course"
                                required
                            >

                                <option value="">
                                    Select a course
                                </option>

                                <option value="Biology 101">
                                    Biology 101
                                </option>

                                <option value="English Composition">
                                    English Composition
                                </option>

                                <option value="Calculus I">
                                    Calculus I
                                </option>

                            </select>

                        </div>

                        <div class="form-group">

                            <label for="tutorName">
                                Tutor
                            </label>

                            <select
                                id="tutorName"
                                name="tutorName"
                                required
                            >

                                <option value="">
                                    Select a tutor
                                </option>

                                <option value="Emily Wilson">
                                    Emily Wilson
                                </option>

                                <option value="Michael Brown">
                                    Michael Brown
                                </option>

                                <option value="Sophia Lee">
                                    Sophia Lee
                                </option>

                            </select>

                        </div>

                        <div class="form-group">

                            <label for="appointmentDate">
                                Date
                            </label>

                            <input
                                id="appointmentDate"
                                name="appointmentDate"
                                type="date"
                                required
                            >

                        </div>

                        <div class="form-group">

                            <label for="appointmentTime">
                                Time
                            </label>

                            <input
                                id="appointmentTime"
                                name="appointmentTime"
                                type="time"
                                required
                            >

                        </div>

                        <div class="form-group">

                            <label for="notes">
                                Notes
                            </label>

                            <textarea
                                id="notes"
                                name="notes"
                                rows="4"
                                placeholder="Describe what you need help with..."
                            ></textarea>

                        </div>

                        <input
                            type="hidden"
                            name="status"
                            value="PENDING"
                        >

                        <button
                            type="submit"
                            class="btn btn-primary btn-block"
                        >
                            Submit Request
                        </button>

                    </form>

                </div>

            </div>

        </div>

    </main>

</div>

<script>

    function scrollToBookingForm() {
        document
            .getElementById("booking-form")
            .scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
    }

    function selectTutor(course, tutorName) {

        document.getElementById("course").value = course;
        document.getElementById("tutorName").value = tutorName;

        scrollToBookingForm();
    }

    function confirmCancel() {
        return confirm(
            "Are you sure you want to cancel this appointment?"
        );
    }

    document.addEventListener("DOMContentLoaded", function () {

        const dateInput =
            document.getElementById("appointmentDate");

        if (dateInput) {

            const today = new Date();

            const year = today.getFullYear();

            const month = String(
                today.getMonth() + 1
            ).padStart(2, "0");

            const day = String(
                today.getDate()
            ).padStart(2, "0");

            dateInput.min =
                year + "-" + month + "-" + day;
        }
    });

</script>

</body>
</html>