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
                <a href="#" class="active"><span class="nav-icon">📊</span> Dashboard</a>
                <a href="#"><span class="nav-icon">👥</span> Users</a>
                <a href="#"><span class="nav-icon">🧑‍🏫</span> Profiles</a>
                <a href="/admin/resources"><span class="nav-icon">📚</span> Resources</a>
                <a href="#"><span class="nav-icon">⭐</span> Reviews</a>
                <a href="#statistics"><span class="nav-icon">📈</span> Statistics</a>
            </nav>

            <div class="sidebar-footer">
                <div class="admin-card">
                    <div class="avatar">SM</div>
                    <div>
                        <div class="admin-name">Shafath Moreano</div>
                        <div class="admin-role">SysAdmin</div>
                    </div>
                </div>
            </div>
        </aside>

        <main class="main">
            <header class="main-header">
                <div>
                    <h1>Admin Dashboard</h1>
                    <p class="greeting">Welcome back, Shafath 👋</p>
                </div>

                <div class="header-actions">
                    <button class="btn">View Reports</button>
                    <button class="btn btn-primary">Manage Users</button>
                </div>
            </header>

            <section class="stats-grid" id="statistics">
                <div class="stat-card">
                    <div class="stat-label">Total Customers</div>
                    <div class="stat-number">${totalCustomers}</div>
                    <div class="stat-change">needs review</div>
                </div>

                <div class="stat-card">
                    <div class="stat-label">Total Appointments</div>
                    <div class="stat-number">${totalAppointments}</div>
                    <div class="stat-change">students and tutors</div>
                </div>

                <div class="stat-card">
                    <div class="stat-label">Total Reviews</div>
                    <div class="stat-number">${totalReviews}</div>
                    <div class="stat-change">open reports</div>
                </div>

                <div class="stat-card">
                    <div class="stat-label">Total Resources</div>
                    <div class="stat-number">${totalResources}</div>
                    <div class="stat-change">study materials</div>
                </div>
            </section>

            <section class="dashboard-grid">
                <div>
                    <div class="card">
                        <div class="card-header">
                            <h2>👥 Manage Users</h2>
                            <span class="badge">admin access</span>
                        </div>
                        <p>View students, tutors, TAs, and Lab Assistants. Admins can manage user roles and give approved users admin access.</p>
                        <button class="btn btn-primary">View Users</button>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h2>🧑‍🏫 Moderate Profiles</h2>
                            <span class="badge">profile review</span>
                        </div>
                        <p>Review tutor profiles and approve official helpers before they appear as available tutors.</p>
                        <button class="btn btn-primary">Review Profiles</button>
                    </div>

                    <div class="feature-card">
                        <h3>📚 Moderate Resources</h3>
                     <p> Review posted study guides and learning resources to make sure they are appropriate for students.</p>
                     <a href="/admin/resources" class="btn btn-primary">
                          Review Resources
                     </a>
                    </div>
                </div>

                <div>
                    <div class="card">
                        <div class="card-header">
                            <h2>⭐ Moderate Reviews</h2>
                            <span class="badge">feedback</span>
                        </div>
                        <p>Review student comments, tutor replies, and reported feedback.</p>
                        <button class="btn btn-primary">Review Reviews</button>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h2>📈 Usage Statistics</h2>
                            <span class="badge">platform activity</span>
                        </div>
                        <p>View active users, tutoring sessions, popular courses, and resource activity.</p>
                        <a href="#statistics" class="btn btn-primary">
                         View Statistics
                        </a>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h2>Admin Summary</h2>
                            <span class="badge">SysAdmin</span>
                        </div>
                        <p>This dashboard demonstrates the SysAdmin use-cases for managing users, moderating platform content, and viewing basic platform activity.</p>
                    </div>
                </div>
            </section>
        </main>
    </div>
</body>
</html>