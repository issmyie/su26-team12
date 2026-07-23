<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>StudySpace · Resources</title>

    <link rel="stylesheet"
          href="/customer/resources.css">
</head>

<body>

<div class="app">

    <!-- Sidebar -->
    <aside class="sidebar">

        <div class="sidebar-brand">
            <span class="brand-icon">📘</span>
            <span>StudySpace</span>
        </div>

        <nav class="sidebar-nav">

            <a href="/customer/dashboard/1">
                <span class="nav-icon">📊</span>
                Dashboard
            </a>

            <a href="/customer/profile/1">
                <span class="nav-icon">👤</span>
                Profile
            </a>

            <a href="/customer/resources"
               class="active">
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

                <div class="avatar">S</div>

                <div>
                    <p class="student-name">${customer.name!"Student"}</p>
                    <p class="student-role">Student</p>
                </div>

            </div>

        </div>

    </aside>

    <!-- Main content -->
    <main class="main">

        <header class="main-header">

            <div>
                <h1>Study Resources</h1>

                <p class="greeting">
                    Find notes, guides, and practice materials for your classes.
                </p>
            </div>

            <div class="header-actions">

                <a class="btn btn-outline"
                   href="/customer/dashboard/1">
                    ← Back to Dashboard
                </a>

                <button class="btn btn-primary"
                        type="button"
                        onclick="showToast('📚 Browse the available resources below.')">
                    View Resources
                </button>

            </div>

        </header>

        <!-- Search -->
        <form class="search-card"
              action="/customer/resources"
              method="get">

            <input type="text"
                   name="title"
                   value="${searchTitle!''}"
                   placeholder="Search resources by title or keyword...">

            <button class="btn btn-primary"
                    type="submit">
                Search
            </button>

            <#if searchTitle?? && searchTitle?has_content>
                <a class="btn"
                   href="/customer/resources">
                    Clear
                </a>
            </#if>

        </form>

        <!-- Statistics -->
        <section class="stats-grid">

            <div class="stat-card">

                <div class="stat-label">
                    Available Resources
                </div>

                <div class="stat-number">
                    ${resources?size}
                </div>

                <span class="stat-change">
                    from database
                </span>

            </div>

            <div class="stat-card">

                <div class="stat-label">
                    Subjects
                </div>

                <div class="stat-number">
                    ${subjectCount!0}
                </div>

                <span class="stat-change">
                    study areas
                </span>

            </div>

            <div class="stat-card">

                <div class="stat-label">
                    Search Results
                </div>

                <div class="stat-number">
                    ${resources?size}
                </div>

                <span class="stat-change">
                    currently shown
                </span>

            </div>

        </section>

        <!-- Resource cards -->
        <div class="resource-grid">

            <#if resources?has_content>

                <#list resources as resource>

                    <div class="card resource-card">

                        <div class="resource-icon">

                            <#if resource.resourceType??>

                                <#if resource.resourceType?lower_case == "video">
                                    🎥
                                <#elseif resource.resourceType?lower_case == "guide">
                                    📘
                                <#elseif resource.resourceType?lower_case == "worksheet">
                                    📝
                                <#elseif resource.resourceType?lower_case == "practice">
                                    📐
                                <#else>
                                    📚
                                </#if>

                            <#else>
                                📚
                            </#if>

                        </div>

                        <h2>
                            ${resource.title!"Untitled Resource"}
                        </h2>

                        <p>
                            ${resource.description!"No description is available."}
                        </p>

                        <div class="resource-details">

                            <span class="badge">
                                ${resource.subject!"General"}
                            </span>

                            <#if resource.category?? &&
                                 resource.category?has_content>

                                <span class="badge">
                                    ${resource.category}
                                </span>

                            </#if>

                            <#if resource.resourceType?? &&
                                 resource.resourceType?has_content>

                                <span class="badge">
                                    ${resource.resourceType}
                                </span>

                            </#if>

                        </div>

                        <#if resource.status?? &&
                             resource.status?has_content>

                            <p class="resource-status">
                                Status:
                                <strong>${resource.status}</strong>
                            </p>

                        </#if>

                        <button class="btn btn-primary"
                                type="button"
                                onclick="showToast('Opened: ${resource.title?js_string}')">
                            Open
                        </button>

                    </div>

                </#list>

            <#else>

                <div class="empty-state">

                    <div class="empty-icon">📭</div>

                    <h2>No resources found</h2>

                    <p>
                        There are no resources matching your search.
                    </p>

                    <a class="btn btn-primary"
                       href="/customer/resources">
                        View All Resources
                    </a>

                </div>

            </#if>

        </div>

    </main>

</div>

<div class="toast"
     id="toast">
</div>

<script>
    function showToast(message) {
        const toast = document.getElementById("toast");

        toast.textContent = message;
        toast.classList.add("show");

        clearTimeout(toast.hideTimer);

        toast.hideTimer = setTimeout(function () {
            toast.classList.remove("show");
        }, 2600);
    }
</script>

</body>

</html>