<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Resources</title>
    <link rel="stylesheet" href="/css/admin-resources.css">
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

            <section class="resources-section">

                <div class="section-header">
                    <div>
                        <h1>Moderate Resources</h1>
                        <p>
                            Review posted study resources and update their
                            moderation status.
                        </p>
                    </div>

                    <a href="/admin"
                       class="btn secondary-btn">
                        Back to Dashboard
                    </a>
                </div>

                <div class="resource-list">

    <#list resources as resource>
        <article class="resource-card">

            <div class="resource-info">
                <h3>${resource.title}</h3>

                <p>
                    <strong>Subject:</strong>
                    ${resource.subject}
                </p>

                <p>
                    <strong>Type:</strong>
                    ${resource.resourceType}
                </p>

                <p>
                    <strong>Status:</strong>
                    ${resource.status!"PENDING"}
                </p>
            </div>

            <div class="resource-actions">

    <form action="/admin/resources/${resource.id}/approve"
          method="post">
        <button type="submit" class="btn approve-btn">
            Approve
        </button>
    </form>

    <form action="/admin/resources/${resource.id}/remove"
          method="post">
        <button type="submit" class="btn remove-btn">
            Remove
        </button>
    </form>

</div>

        </article>
    </#list>

</div>

</body>
</html>