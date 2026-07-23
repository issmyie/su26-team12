<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>StudySpace · Student Profile</title>

    <link rel="stylesheet" href="/customer/profile.css" />
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

             <a href="/customer/profile/${customer.id}" class="active">
                   <span class="nav-icon">👤</span>
                   Profile
             </a>

             <a href="/customer/resources">
                     <span class="nav-icon">📚</span>
                     Resources
             </a>

              <a href="/customer/appointments?customerId=${customer.id}">
                      <span class="nav-icon">📅</span>
                     Appointments
              </a>

            <a href="/customer/reviews">
                        <span class="nav-icon">⭐</span>
                      Reviews
             </a>

        </nav>

        <!-- Student info -->
        <div class="sidebar-footer">
            <div class="student-card">

                <div class="avatar">AC</div>

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

    
    <main class="main">

        
        <header class="main-header">

            <div>
                <h1>Student Profile</h1>

                <p class="greeting">
                    Update your information and study preferences.
                </p>
            </div>

            <div class="header-actions">

                <button
                    class="btn btn-outline"
                    type="button">
                    ← Back to Dashboard
                </button>

                <button
                    class="btn btn-primary"
                    type="submit"
                    form="profileForm">
                    Save Profile
                </button>

            </div>

        </header>

        <!-- P form -->
        <form
            id="profileForm"
            action="/customer/profile/${customer.id?c}/update"
            method="post">

            <div class="profile-grid">

                <div class="left-col">

                    <div class="card">

                        <div class="card-header">
                            <h2>👤 Basic Information</h2>
                            <span class="badge">student info</span>
                        </div>

                        <!-- Name and Email -->
                        <div class="form-row">

                            <div class="form-group">
                                <label for="name">Full Name</label>

                                <input
                                    id="name"
                                    type="text"
                                    name="name"
                                    value="${customer.name!''}"
                                    required>
                            </div>

                            <div class="form-group">
                                <label for="email">Email</label>

                                <input
                                    id="email"
                                    type="email"
                                    name="email"
                                    value="${customer.email!''}"
                                    required>
                            </div>

                        </div>

                        <!-- Academic Info -->
                        <div class="form-row">

                            <div class="form-group">
                                <label for="academicLevel">Year</label>

                                <select
                                    id="academicLevel"
                                    name="academicLevel">

                                    <option
                                        value="Freshman"
                                        <#if (customer.academicLevel!'') == "Freshman">
                                            selected
                                        </#if>>
                                        Freshman
                                    </option>

                                    <option
                                        value="Sophomore"
                                        <#if (customer.academicLevel!'') == "Sophomore">
                                            selected
                                        </#if>>
                                        Sophomore
                                    </option>

                                    <option
                                        value="Junior"
                                        <#if (customer.academicLevel!'') == "Junior">
                                            selected
                                        </#if>>
                                        Junior
                                    </option>

                                    <option
                                        value="Senior"
                                        <#if (customer.academicLevel!'') == "Senior">
                                            selected
                                        </#if>>
                                        Senior
                                    </option>

                                </select>
                            </div>

                            <div class="form-group">
                                <label for="major">Major</label>

                                <input
                                    id="major"
                                    type="text"
                                    name="major"
                                    value="${customer.major!''}"
                                    placeholder="Example: Computer Science">
                            </div>

                        </div>

                        <!-- Preferred Study Time -->
                        <div class="form-group">

                            <label for="preferredStudyTime">
                                Preferred Study Time
                            </label>

                            <select
                                id="preferredStudyTime"
                                name="preferredStudyTime">

                                <option
                                    value="Morning"
                                    <#if (customer.preferredStudyTime!'') == "Morning">
                                        selected
                                    </#if>>
                                    Morning
                                </option>

                                <option
                                    value="Afternoon"
                                    <#if (customer.preferredStudyTime!'') == "Afternoon">
                                        selected
                                    </#if>>
                                    Afternoon
                                </option>

                                <option
                                    value="Evening"
                                    <#if (customer.preferredStudyTime!'') == "Evening">
                                        selected
                                    </#if>>
                                    Evening
                                </option>

                            </select>

                        </div>

                    </div>

                    <!-- Current Courses -->
                    <div class="card">

                        <div class="card-header">
                            <h2>📚 Current Courses</h2>
                            <span class="badge">this semester</span>
                        </div>

                        <div class="tag-list">
                            <span class="tag">Biology 101</span>
                            <span class="tag">English Composition</span>
                            <span class="tag">Calculus I</span>
                        </div>

                        <div class="form-group add-course">

                            <label for="newCourse">Add Course</label>

                            <div class="course-row">

                                <input
                                    id="newCourse"
                                    type="text"
                                    placeholder="e.g. Chemistry 101">

                                <button
                                    class="btn btn-primary"
                                    type="button"
                                    onclick="showToast('➕ Course added!')">
                                    Add
                                </button>

                            </div>

                        </div>

                    </div>

                </div>

                <div class="right-col">

                    <!-- Study Preferences -->
                    <div class="card">

                        <div class="card-header">
                            <h2>⭐ Study Preferences</h2>
                            <span class="badge">saved profile data</span>
                        </div>

                        <div class="preference-item">
                            <span>Preferred Time</span>

                            <strong>
                                ${customer.preferredStudyTime!"Not selected"}
                            </strong>
                        </div>

                        <div class="preference-item">
                            <span>Academic Level</span>

                            <strong>
                                ${customer.academicLevel!"Not selected"}
                            </strong>
                        </div>

                        <div class="preference-item">
                            <span>Major</span>

                            <strong>
                                ${customer.major!"Not provided"}
                            </strong>
                        </div>

                        <div class="preference-item">
                            <span>Learning Style</span>
                            <strong>Practice Problems</strong>
                        </div>

                    </div>

                    <!-- Account Summary -->
                    <div class="card">

                        <div class="card-header">
                            <h2>📌 Account Summary</h2>
                            <span class="badge">overview</span>
                        </div>

                        <p>
                            <strong>Customer ID:</strong>
                            ${customer.id?c}
                        </p>

                        <p>
                            <strong>Account Status:</strong>
                            ${customer.accountStatus!"Unknown"}
                        </p>

                        <p>
                            <strong>Role:</strong>
                            ${customer.role!"STUDENT"}
                        </p>

                        <p>
                            <strong>Profile Status:</strong>
                            ${customer.profileStatus!"APPROVED"}
                        </p>

                        <p>
                            <strong>Email:</strong>
                            ${customer.email!""}
                        </p>

                    </div>

                </div>

            </div>

        </form>

    </main>

</div>

<div class="toast" id="toast"></div>

<script>

    function showToast(message) {
        const toast = document.getElementById("toast");

        toast.textContent = message;
        toast.classList.add("show");

        clearTimeout(toast.timeout);

        toast.timeout = setTimeout(() => {
            toast.classList.remove("show");
        }, 2600);
    }

</script>

</body>
</html>