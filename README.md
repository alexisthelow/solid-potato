# solid-potato

A thing that takes a webpage and creates a searchable index of all the words. It probably isn't a potato.

## Design Decisions
Since we were charged with implementing our own LinkedLists for this project, I thought I'd begin by rewriting LinkedList from the ground up... but once I figured out how much work that would take, I paused and thought about what I actually needed, and found that all I really needed was the ability to add words to the list (and always in alphabetical order), and to pull something out of the list. So, that is all StringLinkedList can do.

As for UrlLinkedList, I didn't need to keep them in alphabetical order, but I did want to keep track of how many times a given word appeared in the page, to provide better search results in the future.

Once those were working, I took at look at the Page class that was provided for use as the core of the project. However, I couldn't get it to work, and quite frankly I didn't feel like debugging it at the time, so I wrote a different class, PageScraper, which works quite well. This class uses JSoup to extract words and links from the page--considering we WERE given a bunch of code to start with, it seemed reasonably fair to do so.

As for the GUI, I used code from another project of mine--an app I've been writing along with a Swing tutorial. I thought the look of it would work well in this project, so I copied over what I needed and made modifications as necessary.

The app seems, to me, to be well-formed--all of the logical things are handled in the MainFrame class.

## Future Work

### Bugs
The app should notify the user when it fails to scrape a page and why. Currently, it just doesn't, and throws an exception. However, it doesn't crash as a result, and I see this as generally positive.

The app should notify the user if they entered a bad URL. Even better, the app should take whatever it is given and attempt to form a good URL, and then notify the user if it can't. Currently, it just throws an exception (but does not crash).

### Needs
The app should be modifiable--currently, it is set to scrape the first 30 pages it finds. The user should be able to, at minimum, change that number. Also, the list of stop words (words that are ignored by PageScraper) is set and can't be changed; the user should be able to specify which words to ignore to better handle edge use cases (what if they want to search for the band The The? what if they're a beginner electrical engineering student looking for information on OR gates?).

### Wants
I'd like to go back over this and make it a little more convenient by using built-in LinkedLists. What I made works fine, but I sacrificed a lot of convenience for the sake of saving time, and that sacrifice will make it harder to rework the project later on. (However, I appreciated the challenge of implementing LinkedLists myself--I now have a richer understanding of the structure.)

I'd like the app to take advantage of multiple threads--currently, it scrapes one page at a time, so it's a bit slow.

The app should have some kind of display indicating what's going on--what page is being scraped, how many are left, the estimated time it will take, et cetera. Some of these things are indicated in the console, but the end user isn't going to be able to see the console.

It would be nice if there were other options to restrict the scrape: perhaps by same page (restricting scraped links to ones with the same base URL), perhaps by page depth.

As long as we're scraping words, we might as well scrape other things--links, images, et cetera.

It would be nice if the app were prettier. It's pretty ugly, don't you think? In time, I'd like to see if I can redo this in JavaFX. The output of searches is QUITE ugly and definitely needs work.
