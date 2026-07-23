<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Profiles</title>
    <link rel="stylesheet" href="/css/admin-profiles.css">
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
                <h1>Moderate Provider Profiles</h1>
                <p>Review provider information and approve or reject profiles.</p>
            </div>

            <a href="/admin" class="btn secondary-btn">
                Back to Dashboard
            </a>

        </div>

        <section class="profile-list">

            <#if providers?size == 0>

                <p>No provider profiles found.</p>

            <#else>

                <#list providers as provider>

                    <article class="profile-card">

                        <div class="profile-info">

                            <h3>${provider.name!"Unnamed Provider"}</h3>

                            <p>
                                <strong>Email:</strong>
                                ${provider.email!"Not Set"}
                            </p>

                            <p>
                                <strong>Major:</strong>
                                ${provider.major!"Not Set"}
                            </p>

                            <p>
                                <strong>Academic Level:</strong>
                                ${provider.academicLevel!"Not Set"}
                            </p>

                            <p>
                                <strong>Years of Experience:</strong>
                                ${provider.yearsExperience!"Not Set"}
                            </p>

                            <p>
                                <strong>Bio:</strong>
                                ${provider.bio!"No bio provided"}
                            </p>

                            <p>
                                <strong>Profile Status:</strong>
                                ${provider.profileStatus!"PENDING"}
                            </p>

                        </div>

                        <div class="profile-actions">

                            <form
                                action="/admin/profiles/${provider.id}/approve"
                                method="post">

                                <button type="submit" class="btn approve-btn">
                                    Approve
                                </button>

                            </form>

                            <form
                                action="/admin/profiles/${provider.id}/reject"
                                method="post">

                                <button type="submit" class="btn reject-btn">
                                    Reject
                                </button>

                            </form>

                        </div>

                    </article>

                </#list>

            </#if>

        </section>

    </main>

</div>
</body>
</html>