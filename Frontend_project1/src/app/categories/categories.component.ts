import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface Category {
  id: number;
  name: string;
  imageUrl: string;
}

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent {
  categories: Category[] = [
    { id: 1, name: 'Fiction', imageUrl: 'assets/images/science.jpeg' },
    { id: 2, name: 'Non-Fiction', imageUrl: 'assets/images/non-fiction.jpeg' },
    { id: 3, name: 'Science', imageUrl: 'assets/images/harry.jpg' },
    { id: 4, name: 'Romance', imageUrl: 'assets/images/romance.jpeg' },
    { id: 5, name: 'Mystery', imageUrl: 'assets/images/mystery.jpg' },
    { id: 6, name: 'Computers & Internet', imageUrl: 'assets/images/computers & internet.jpg' },
    { id: 7, name: 'Dance', imageUrl: 'assets/images/dance.jpg' },
    { id: 8, name: 'Business & Economics', imageUrl: 'assets/images/business.jpg' }
  ];

  constructor(private router: Router) {}

  // Navigate to products page for the selected category
  selectCategory(category: Category): void {
    this.router.navigate(['/categories', category.id]);  // Navigate to products with categoryId
  }
    // Navigate to Products Page
    goproducts() {
      console.log('Navigating to products...');
      this.router.navigate(['/products']);
    }
  
}
