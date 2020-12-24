import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { PostService } from 'app/core/user/post.service';

@Component({
  selector: 'jhi-post-temp',
  templateUrl: './post-temp.component.html',
  styleUrls: ['./post-temp.component.scss']
})
export class PostTempComponent implements OnInit {

  likes = 0;
  name = 'a';

  constructor(private postService: PostService, private cd: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    console.log('initing....');
    this.postService.newObservable(3).subscribe(
      result => {
        this.updateLike(result.data);
        console.log(this.likes);
        this.cd.detectChanges();
      }
    );
  }

  updateLike(data: any): void {
    this.likes = data;
  }
}
