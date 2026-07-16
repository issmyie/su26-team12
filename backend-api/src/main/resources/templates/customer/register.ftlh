<form action="/customer/register" method="post">
    <label>Name</label>
    <input type="text" name="name" required>

    <label>Email</label>
    <input type="email" name="email" required>

    <label>Password</label>
    <input type="password" name="password" required>

    <label>Major</label>
    <input type="text" name="major">

    <label>Academic Level</label>
    <select name="academicLevel">
        <option>Freshman</option>
        <option>Sophomore</option>
        <option>Junior</option>
        <option>Senior</option>
    </select>

    <label>Preferred Study Time</label>
    <select name="preferredStudyTime">
        <option>Morning</option>
        <option>Afternoon</option>
        <option>Evening</option>
    </select>

    <button type="submit">Create Account</button>
</form>