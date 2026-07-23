<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>StudyHub Admin Dashboard</title>
    <link rel="stylesheet" href="/css/admin-dashboard.css">
</head>
<body>
    <div class="app">
     <aside class="sidebar">

    <div class="sidebar-brand">
        <span class="brand-icon">📘</span>
        <span>StudySpace</span>
    </div>

    <nav class="sidebar-nav">

        <a href="/admin" class="active">
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

        <main class="main">

    <header class="main-header">
        <div>
            <h1>Admin Dashboard</h1>
            <p class="greeting">Welcome back, Shafath 👋</p>
        </div>

        <div class="header-actions">
            <a href="/admin/statistics" class="btn">
                View Reports
            </a>

            <a href="/admin/users" class="btn btn-primary">
                Manage Users
            </a>
        </div>
    </header>

    <section class="stats-grid" id="statistics">

        <div class="stat-card">
            <div class="stat-label">Total Customers</div>
            <div class="stat-number">${totalCustomers!0}</div>
            <div class="stat-change">needs review</div>
        </div>

        <div class="stat-card">
            <div class="stat-label">Total Appointments</div>
            <div class="stat-number">${totalAppointments!0}</div>
            <div class="stat-change">students and tutors</div>
        </div>

        <div class="stat-card">
            <div class="stat-label">Total Reviews</div>
            <div class="stat-number">${totalReviews!0}</div>
            <div class="stat-change">open reports</div>
        </div>

        <div class="stat-card">
            <div class="stat-label">Total Resources</div>
            <div class="stat-number">${totalResources!0}</div>
            <div class="stat-change">study materials</div>
        </div>

    </section>

    <section class="dashboard-grid">

        <div class="dashboard-column">

            <div class="card">
                <div class="card-header">
                    <h2>👥 Manage Users</h2>
                    <span class="badge">admin access</span>
                </div>

                <p>
                    View students, tutors, TAs, and Lab Assistants.
                    Admins can manage user accounts and access.
                </p>

                <a href="/admin/users" class="btn btn-primary">
                    View Users
                </a>
            </div>

            <div class="card">
                <div class="card-header">
                    <h2>🧑‍🏫 Moderate Profiles</h2>
                    <span class="badge">profile review</span>
                </div>

                <p>
                    Review tutor profiles and approve official helpers before
                    they appear as available tutors.
                </p>

                <a href="/admin/profiles" class="btn btn-primary">
                    Review Profiles
                </a>
            </div>

            <div class="card">
                <div class="card-header">
                    <h2>📚 Moderate Resources</h2>
                    <span class="badge">study materials</span>
                </div>

                <p>
                    Review posted study guides and learning resources to make
                    sure they are appropriate for students.
                </p>

                <a href="/admin/resources" class="btn btn-primary">
                    Review Resources
                </a>
            </div>

        </div>

        <div class="dashboard-column">

            <div class="card">
                <div class="card-header">
                    <h2>⭐ Moderate Reviews</h2>
                    <span class="badge">feedback</span>
                </div>

                <p>
                    Review student comments, tutor replies, and reported
                    feedback.
                </p>

                <a href="/admin/reviews" class="btn btn-primary">
                    Review Reviews
                </a>
            </div>

            <div class="card">
                <div class="card-header">
                    <h2>📈 Usage Statistics</h2>
                    <span class="badge">platform activity</span>
                </div>

                <p>
                    View active users, tutoring sessions, popular courses,
                    and resource activity.
                </p>

                <a href="/admin/statistics" class="btn btn-primary">
                    View Statistics
                </a>
            </div>

            <div class="card">
                <div class="card-header">
                    <h2>Admin Summary</h2>
                    <span class="badge">SysAdmin</span>
                </div>

                <p>
                    This dashboard demonstrates the SysAdmin use cases for
                    managing users, moderating platform content, and viewing
                    basic platform activity.
                </p>
            </div>

        </div>

    </section>

</main>
    </div>
</body>
</html>