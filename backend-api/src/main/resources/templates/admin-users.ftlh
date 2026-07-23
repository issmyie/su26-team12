<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Users</title>
    <link rel="stylesheet" href="/css/admin-users.css">
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

            <a href="/admin/users" class="active">
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
                <h1>Manage Users</h1>
                <p>
                    View customers and providers, manage account access,
                    and assign administrator privileges.
                </p>
            </div>

            <a href="/admin" class="btn secondary-btn">
                Back to Dashboard
            </a>

        </div>

        <section class="user-section">

            <h2>Customers</h2>

            <#if customers?size == 0>

                <p>No customers found.</p>

            <#else>

                <div class="table-wrapper">

                    <table>

                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Account Status</th>
                            <th>Profile Status</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>

                        <#list customers as customer>

                            <tr>

                                <td>${customer.id}</td>

                                <td>${customer.name!"Unnamed Customer"}</td>

                                <td>${customer.email!"Not Set"}</td>

                                <td>${customer.role!"CUSTOMER"}</td>

                                <td>${customer.accountStatus!"NOT SET"}</td>

                                <td>${customer.profileStatus!"Not Set"}</td>

                                <td>

                                    <div class="user-actions">

                                        <form
                                            action="/admin/users/customer/${customer.id}/enable"
                                            method="post">

                                            <button
                                                type="submit"
                                                class="btn enable-btn">

                                                Enable

                                            </button>

                                        </form>

                                        <form
                                            action="/admin/users/customer/${customer.id}/disable"
                                            method="post">

                                            <button
                                                type="submit"
                                                class="btn disable-btn">

                                                Disable

                                            </button>

                                        </form>

                                        <#if (customer.role!"CUSTOMER") == "ADMIN">

                                            <form
                                                action="/admin/users/customers/${customer.id}/remove-admin"
                                                method="post">

                                                <button
                                                    type="submit"
                                                    class="btn remove-admin-btn">

                                                    Remove Admin

                                                </button>

                                            </form>

                                        <#else>

                                            <form
                                                action="/admin/users/customers/${customer.id}/make-admin"
                                                method="post">

                                                <button
                                                    type="submit"
                                                    class="btn make-admin-btn">

                                                    Make Admin

                                                </button>

                                            </form>

                                        </#if>

                                    </div>

                                </td>

                            </tr>

                        </#list>

                        </tbody>

                    </table>

                </div>

            </#if>

        </section>

        <section class="user-section">

            <h2>Providers</h2>

            <#if providers?size == 0>

                <p>No providers found.</p>

            <#else>

                <div class="table-wrapper">

                    <table>

                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Account Status</th>
                            <th>Profile Status</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>

                        <#list providers as provider>

                            <tr>

                                <td>${provider.id}</td>

                                <td>${provider.name!"Unnamed Provider"}</td>

                                <td>${provider.email!"Not Set"}</td>

                                <td>${provider.role!"PROVIDER"}</td>

                                <td>${provider.accountStatus!"NOT SET"}</td>

                                <td>${provider.profileStatus!"Not Set"}</td>

                                <td>

                                    <div class="user-actions">

                                        <form
                                            action="/admin/users/provider/${provider.id}/enable"
                                            method="post">

                                            <button
                                                type="submit"
                                                class="btn enable-btn">

                                                Enable

                                            </button>

                                        </form>

                                        <form
                                            action="/admin/users/provider/${provider.id}/disable"
                                            method="post">

                                            <button
                                                type="submit"
                                                class="btn disable-btn">

                                                Disable

                                            </button>

                                        </form>

                                        <#if (provider.role!"PROVIDER") == "ADMIN">

                                            <form
                                                action="/admin/users/providers/${provider.id}/remove-admin"
                                                method="post">

                                                <button
                                                    type="submit"
                                                    class="btn remove-admin-btn">

                                                    Remove Admin

                                                </button>

                                            </form>

                                        <#else>

                                            <form
                                                action="/admin/users/providers/${provider.id}/make-admin"
                                                method="post">

                                                <button
                                                    type="submit"
                                                    class="btn make-admin-btn">

                                                    Make Admin

                                                </button>

                                            </form>

                                        </#if>

                                    </div>

                                </td>

                            </tr>

                        </#list>

                        </tbody>

                    </table>

                </div>

            </#if>

        </section>

    </main>

</div>
</body>
</html>