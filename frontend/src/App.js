import React, { useEffect, useState } from 'react';
import {
  Container, AppBar, Toolbar, Typography, Grid, Button,
  Dialog, DialogTitle, DialogContent, TextField, DialogActions, Box,
} from '@mui/material';
import CourseCard from './components/CourseCard.js';
import './App.css';

function App() {
  const [courses, setCourses] = useState([]);
  const [selected, setSelected] = useState(null);
  const [open, setOpen] = useState(false);
  const [name, setName] = useState('');
  const [selectedSubject, setSelectedSubject] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/courses')
      .then(r => r.json())
      .then(setCourses)
      .catch(err => console.error('Could not fetch courses', err));
  }, []);

  const handleEnroll = (course) => {
    setSelected(course);
    setOpen(true);
  };

  const submitEnroll = () => {
    const payload = { name, coaching: false, coachingType: '', selectedSubject };
    fetch(`http://localhost:8080/enroll/${selected.id}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload),
    })
      .then(r => r.text())
      .then(() => {
        alert('Success: Enrolled in ' + selected.title + (selectedSubject ? ' - ' + selectedSubject : ''));
        setOpen(false);
        setSelectedSubject('');
      })
      .catch(() => alert('Failed to enroll'));
  };

  const oneToOneCourses = courses.filter(c => c.type === 'one-to-one');
  const groupCourses = courses.filter(c => c.type !== 'one-to-one');

  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6">Btsay - Courses</Typography>
        </Toolbar>
      </AppBar>

      <Container sx={{ marginTop: 4 }}>
        {/* One-to-One Courses – displayed outside the main group grid */}
        {oneToOneCourses.length > 0 && (
          <Box sx={{ mb: 5 }}>
            <Typography variant="h5" gutterBottom>
              One-to-One Courses
            </Typography>
            <Grid container spacing={2}>
              {oneToOneCourses.map(c => (
                <Grid item xs={12} sm={6} md={4} key={c.id}>
                  <CourseCard course={c} onEnroll={() => handleEnroll(c)} />
                </Grid>
              ))}
            </Grid>
          </Box>
        )}

        {/* Group / All Courses */}
        <Typography variant="h5" gutterBottom>
          All Courses
        </Typography>
        <Grid container spacing={2}>
          {groupCourses.map(c => (
            <Grid item xs={12} sm={6} md={4} key={c.id}>
              <CourseCard course={c} onEnroll={() => handleEnroll(c)} />
            </Grid>
          ))}
        </Grid>
      </Container>

      <Dialog open={open} onClose={() => setOpen(false)}>
        <DialogTitle>Enroll in {selected?.title}</DialogTitle>
        <DialogContent>
          <TextField
            label="Your name"
            fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
            sx={{ mt: 2 }}
          />
          <div style={{ marginTop: 16 }}>
            <label style={{ display: 'block', marginBottom: 8, fontWeight: 'bold' }}>
              Select your preferred subject:
            </label>
            <select
              value={selectedSubject}
              onChange={(e) => setSelectedSubject(e.target.value)}
              style={{ width: '100%', padding: 8, borderRadius: 4, border: '1px solid #ccc' }}
            >
              <option value="">-- Choose a subject --</option>
              <option value="Psychology">Psychology</option>
              <option value="Personal Development">Personal Development</option>
            </select>
          </div>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => { setOpen(false); setSelectedSubject(''); }}>Cancel</Button>
          <Button onClick={submitEnroll} variant="contained">Enroll</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default App;
