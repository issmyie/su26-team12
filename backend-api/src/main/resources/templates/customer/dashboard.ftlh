<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>StudySpace · Student Dashboard</title>

    <link rel="stylesheet"
          href="/customer/dashboard.css">
</head>

<body>

<div class="app">

    <aside class="sidebar">

        <div class="sidebar-brand">
            <span class="brand-icon">📘</span>
            <span>StudySpace</span>
        </div>

        <nav class="sidebar-nav">

            <a href="/customer/dashboard/${customer.id}"
               class="active">
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

            <a href="/customer/appointments">
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
                    ${(customer.name!"S")?substring(0, 1)?upper_case}
                </div>

                <div>
                    <p class="student-name">
                        ${customer.name!"Student"}
                    </p>

                    <p class="student-role">
                        ${customer.role!"Student"}
                    </p>
                </div>

            </div>

        </div>

    </aside>

    <main class="main">

        <header class="main-header">

            <div>
                <h1>Student Dashboard</h1>

                <p class="greeting">
                    Welcome back, ${customer.name!"Student"} 👋
                </p>
            </div>

            <div class="header-actions">

                <button class="btn btn-outline"
                        onclick="window.location.href='/customer/profile/${customer.id}'">
                    Edit Profile
                </button>

                <button class="btn btn-primary"
                        onclick="window.location.href='/customer/appointments'">
                    Book Session
                </button>

            </div>

        </header>

        <section class="stats-grid">

            <div class="stat-card">
                <div class="stat-label">Upcoming Sessions</div>
                <div class="stat-number">
                    ${upcomingSessionCount}
                </div>
                <span class="stat-change">this week</span>
            </div>

            <div class="stat-card">
                <div class="stat-label">Saved Resources</div>
                <div class="stat-number">
                    ${savedResourceCount}
                </div>
                <span class="stat-change">available</span>
            </div>

            <div class="stat-card">
                <div class="stat-label">Completed Sessions</div>
                <div class="stat-number">
                    ${completedSessionCount}
                </div>
                <span class="stat-change">good progress</span>
            </div>

            <div class="stat-card">
                <div class="stat-label">Reviews Given</div>
                <div class="stat-number">
                    ${reviewCount}
                </div>
                <span class="stat-change">active user</span>
            </div>

        </section>

        <div class="dashboard-grid">

            <div class="left-col">

                <div class="card">

                    <div class="card-header">
                        <h2>📅 Upcoming Appointments</h2>
                        <span class="badge">next sessions</span>
                    </div>

                    <p>
                        Appointment information will appear here.
                    </p>

                    <button class="btn btn-primary"
                            onclick="window.location.href='/customer/appointments'">
                        View Appointments
                    </button>

                </div>

                <div class="card">

                    <div class="card-header">
                        <h2>📚 Recommended Resources</h2>
                        <span class="badge">for you</span>
                    </div>

                    <p>
                        Recommended resources will appear here.
                    </p>

                    <button class="btn btn-primary"
                            onclick="window.location.href='/customer/resources'">
                        View Resources
                    </button>

                </div>

            </div>

            <div class="right-col">

                <div class="card">

                    <div class="card-header">
                        <h2>👤 Profile Summary</h2>
                        <span class="badge">student info</span>
                    </div>

                    <p>
                        <strong>Name:</strong>
                        ${customer.name!"Not provided"}
                    </p>

                    <p>
                        <strong>Email:</strong>
                        ${customer.email!"Not provided"}
                    </p>

                    <p>
                        <strong>Role:</strong>
                        ${customer.role!"Student"}
                    </p>

                    <p>
                        <strong>Major:</strong>
                        ${customer.major!"Not provided"}
                    </p>

                    <p>
                        <strong>Preferred Study Time:</strong>
                        ${customer.preferredStudyTime!"Not provided"}
                    </p>

                    <button class="btn btn-primary"
                            onclick="window.location.href='/customer/profile/${customer.id}'">
                        Update Profile
                    </button>

                </div>

                <div class="card">

                    <div class="card-header">
                        <h2>⭐ Reviews</h2>
                        <span class="badge">feedback</span>
                    </div>

                    <p class="review-text">
                        View your submitted tutor reviews or write a new one.
                    </p>

                    <button class="btn btn-primary"
                            onclick="window.location.href='/customer/reviews'">
                        View Reviews
                    </button>

                </div>

            </div>

        </div>

    </main>

</div>

</body>
</html>