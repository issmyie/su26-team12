<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Reviews</title>
    <link rel="stylesheet" href="/css/admin-reviews.css">
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
                <h1>Moderate Reviews</h1>
                <p>Review student feedback and control whether reviews are visible.</p>
            </div>

            <a href="/admin" class="btn secondary-btn">
                Back to Dashboard
            </a>
        </div>

        <section class="review-section">

            <#if reviews?size == 0>
                <p>No reviews found.</p>
            <#else>
                <div class="review-list">

                    <#list reviews as review>
                        <article class="review-card">

                            <div class="review-info">
                                <h3>Review #${review.id}</h3>

                                <p>
                                    <strong>Customer ID:</strong>
                                    ${review.customerId!"Not Set"}
                                </p>

                                <p>
                                    <strong>Appointment ID:</strong>
                                    ${review.appointmentId!"Not Set"}
                                </p>

                                <p>
                                    <strong>Tutor:</strong>
                                    ${review.tutorName!"Not Set"}
                                </p>

                                <p>
                                    <strong>Rating:</strong>
                                    ${review.rating!"Not Set"}
                                </p>

                                <p>
                                    <strong>Comment:</strong>
                                    ${review.comment!"No comment"}
                                </p>

                                <p>
                                    <strong>Status:</strong>
                                    ${review.status!"VISIBLE"}
                                </p>

                                <#if review.reply?? && review.reply?has_content>
                                    <p>
                                        <strong>Provider Reply:</strong>
                                        ${review.reply}
                                    </p>
                                </#if>
                            </div>

                            <div class="review-actions">

                                <form action="/admin/reviews/${review.id}/show"
                                      method="post">
                                    <button type="submit" class="btn show-btn">
                                        Show
                                    </button>
                                </form>

                                <form action="/admin/reviews/${review.id}/hide"
                                      method="post">
                                    <button type="submit" class="btn hide-btn">
                                        Hide
                                    </button>
                                </form>

                            </div>
                        </article>
                    </#list>

                </div>
            </#if>

        </section>
    </main>
</div>
</body>
</html>