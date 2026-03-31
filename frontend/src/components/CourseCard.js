import React from 'react';
import { Card, CardContent, Typography, CardActions, Button } from '@mui/material';

export default function CourseCard({ course, onEnroll }) {
  return (
    <Card sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flexGrow: 1 }}>
        <Typography variant="h5" component="h2" gutterBottom>
          {course.title}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {course.description}
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small" variant="contained" onClick={onEnroll}>
          Enroll
        </Button>
      </CardActions>
    </Card>
  );
}
