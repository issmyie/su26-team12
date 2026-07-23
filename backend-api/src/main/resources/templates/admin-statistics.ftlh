<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Statistics</title>
    <link rel="stylesheet" href="/css/admin-statistics.css">
</head>

<body>
<div class="app">

    <aside class="sidebar">

    <div class="sidebar-brand">
        <span class="brand-icon">📘</span>
        <span>StudySpace</span>
    </div>

    <nav class="sidebar-nav">

        <a href="/admin">
            <span class="nav-icon">📊</span>
            Dashboard
        </a>

        <a href="/admin/users">
            <span class="nav-icon">👥</span>
            Users
        </a>

        <a href="/admin/profiles">
            <span class="nav-icon">🧑‍🏫</span>
            Profiles
        </a>

        <a href="/admin/resources">
            <span class="nav-icon">📚</span>
            Resources
        </a>

        <a href="/admin/reviews">
            <span class="nav-icon">⭐</span>
            Reviews
        </a>

        <a href="/admin/statistics">
            <span class="nav-icon">📈</span>
            Statistics
        </a>

    </nav>

    <div class="sidebar-footer">

        <div class="admin-profile">

            <div class="admin-avatar">
                SM
            </div>

            <div class="admin-details">
                <strong>Shafath Moreano</strong>
                <span>SysAdmin</span>
            </div>

        </div>

        <a href="/logout" class="logout-link">
            <span class="nav-icon">🚪</span>
            Logout
        </a>

    </div>

</aside>

    <main class="main-content">

        <div class="section-header">
            <div>
                <h1>Usage Statistics</h1>
                <p>View current StudySpace activity stored in PostgreSQL.</p>
            </div>

            <a href="/admin" class="btn secondary-btn">
                Back to Dashboard
            </a>
        </div>

        <section class="stats-grid">

            <article class="stat-card">
                <p class="stat-label">Total Customers</p>
                <p class="stat-number">${totalCustomers}</p>
                <p class="stat-description">Registered student accounts</p>
            </article>

            <article class="stat-card">
                <p class="stat-label">Total Appointments</p>
                <p class="stat-number">${totalAppointments}</p>
                <p class="stat-description">Tutoring subscriptions and bookings</p>
            </article>

            <article class="stat-card">
                <p class="stat-label">Total Reviews</p>
                <p class="stat-number">${totalReviews}</p>
                <p class="stat-description">Student feedback records</p>
            </article>

            <article class="stat-card">
                <p class="stat-label">Total Resources</p>
                <p class="stat-number">${totalResources}</p>
                <p class="stat-description">Posted study materials</p>
            </article>

        </section>

    </main>
</div>
</body>
</html>