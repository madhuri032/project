import { Component } from '@angular/core';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {
  reviews = [
    { rating: 5, author: 'John Doe', comment: 'Great product!' },
    { rating: 4, author: 'Jane Doe', comment: 'Good, but could be improved.' }
  ];

  newReview = {
    rating: 0, // Rating should be a number
    comment: '' // Comment is a string
  };

  submitReview() {
    if (this.newReview.rating && this.newReview.comment) {
      this.reviews.push({
        rating: this.newReview.rating,  // Ensure it's a number
        author: 'Anonymous',
        comment: this.newReview.comment
      });
      this.newReview = { rating: 0, comment: '' };  // Reset after submission
    }
  }
}
