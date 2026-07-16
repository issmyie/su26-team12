<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>StudySpace · Student Reviews</title>

    <link rel="stylesheet" href="/customer/reviews.css" />
</head>

<body>

<div class="app">

    <aside class="sidebar">

        <div class="sidebar-brand">
            <span class="brand-icon">📘</span>
            <span>StudySpace</span>
        </div>

        <nav class="sidebar-nav">

            <a href="#">
                <span class="nav-icon">📊</span>
                Dashboard
            </a>

            <a href="/customer/profile/1">
                <span class="nav-icon">👤</span>
                Profile
            </a>

            <a href="#">
                <span class="nav-icon">📚</span>
                Resources
            </a>

            <a href="#">
                <span class="nav-icon">📅</span>
                Appointments
            </a>

            <a href="/customer/reviews" class="active">
                <span class="nav-icon">⭐</span>
                Reviews
            </a>

        </nav>

        <!-- Student info -->
        <div class="sidebar-footer">
            <div class="student-card">

                <div class="avatar">AC</div>

                <div>
                    <p class="student-name">Alex Carter</p>
                    <p class="student-role">Student</p>
                </div>

            </div>
        </div>

    </aside>


    <main class="main">

        <header class="main-header">

            <div>
                <h1>Reviews</h1>

                <p class="greeting">
                    Leave feedback for completed tutoring sessions.
                </p>
            </div>

            <div class="header-actions">
                <button class="btn btn-outline" type="button">
                    ← Back to Dashboard
                </button>
            </div>

        </header>

        <!-- Review statistics -->
        <section class="stats-grid">

            <div class="stat-card">
                <div class="stat-label">Reviews Given</div>

                <div class="stat-number">
                    ${reviews?size}
                </div>

                <span class="stat-change">active user</span>
            </div>

            <div class="stat-card">
                <div class="stat-label">Completed Sessions</div>
                <div class="stat-number">12</div>
                <span class="stat-change">ready to review</span>
            </div>

            <div class="stat-card">
                <div class="stat-label">Average Rating</div>

                <div class="stat-number">
                    <#if reviews?size gt 0>
                        <#assign totalRating = 0>

                        <#list reviews as review>
                            <#assign totalRating = totalRating + review.rating>
                        </#list>

                        ${(totalRating / reviews?size)?string["0.0"]}
                    <#else>
                        0.0
                    </#if>
                </div>

                <span class="stat-change">student feedback</span>
            </div>

        </section>

        <div class="reviews-grid">

            <div class="left-col">

                <div class="card">

                    <div class="card-header">
                        <h2>📝 Write a Review</h2>
                        <span class="badge">new feedback</span>
                    </div>

                    <form action="/customer/reviews" method="post">

                        <input
                            type="hidden"
                            name="appointmentId"
                            value="1">

                        <div class="form-group">
                            <label for="tutorName">
                                Completed Session
                            </label>

                            <select
                                id="tutorName"
                                name="tutorName"
                                required>

                                <option value="Emily Wilson">
                                    Biology 101 with Emily Wilson
                                </option>

                                <option value="Michael Brown">
                                    English Composition with Michael Brown
                                </option>

                                <option value="Sophia Lee">
                                    Calculus I with Sophia Lee
                                </option>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="rating">Rating</label>

                            <select
                                id="rating"
                                name="rating"
                                required>

                                <option value="5">
                                    ★★★★★ - Excellent
                                </option>

                                <option value="4">
                                    ★★★★ - Good
                                </option>

                                <option value="3">
                                    ★★★ - Okay
                                </option>

                                <option value="2">
                                    ★★ - Needs Improvement
                                </option>

                                <option value="1">
                                    ★ - Poor
                                </option>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="comment">
                                Review Comment
                            </label>

                            <textarea
                                id="comment"
                                name="comment"
                                placeholder="Write your feedback here..."
                                required></textarea>
                        </div>

                        <button
                            class="btn btn-primary"
                            type="submit">
                            Submit Review
                        </button>

                    </form>

                </div>

                <!-- Completed Sessions -->
                <div class="card">

                    <div class="card-header">
                        <h2>✅ Completed Sessions</h2>
                        <span class="badge">available to review</span>
                    </div>

                    <div class="session-item">
                        <div>
                            <h3>Biology 101 Tutoring</h3>
                            <p>Emily Wilson · July 2, 2026</p>
                        </div>
                    </div>

                    <div class="session-item">
                        <div>
                            <h3>English Composition Help</h3>
                            <p>Michael Brown · June 28, 2026</p>
                        </div>
                    </div>

                    <div class="session-item">
                        <div>
                            <h3>Calculus I Practice</h3>
                            <p>Sophia Lee · June 20, 2026</p>
                        </div>
                    </div>

                </div>

            </div>

            
            <div class="right-col">

                <div class="card">

                    <div class="card-header">
                        <h2>⭐ My Recent Reviews</h2>
                        <span class="badge">history</span>
                    </div>

                    <#if reviews?size == 0>

                        <p>No reviews submitted yet.</p>

                    <#else>

                        <#list reviews as review>

                            <div class="review-card">

                                <div class="review-top">

                                    <strong>
                                        ${review.tutorName!"Unknown Tutor"}
                                    </strong>

                                    <span class="stars">
                                        <#if review.rating == 5>
                                            ★★★★★
                                        <#elseif review.rating == 4>
                                            ★★★★
                                        <#elseif review.rating == 3>
                                            ★★★
                                        <#elseif review.rating == 2>
                                            ★★
                                        <#else>
                                            ★
                                        </#if>
                                    </span>

                                </div>

                                <p>
                                    ${review.comment!"No comment provided."}
                                </p>

                                <#if review.reply?? && review.reply?has_content>

                                    <p>
                                        <strong>Provider Reply:</strong>
                                        ${review.reply}
                                    </p>

                                </#if>

                            </div>

                        </#list>

                    </#if>

                </div>

            </div>

        </div>

    </main>

</div>

</body>
</html>