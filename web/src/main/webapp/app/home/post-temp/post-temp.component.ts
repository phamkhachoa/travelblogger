import { Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/user/post.service';

@Component({
  selector: 'jhi-post-temp',
  templateUrl: './post-temp.component.html',
  styleUrls: ['./post-temp.component.scss']
})
export class PostTempComponent implements OnInit {

  likes: Number = 0;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.postService.newObservable(3).subscribe();
  }
}
