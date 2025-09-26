# Spätsche Bahn
An app to count how late the Deutsche Bahn got you in total.

## What this app should feature in the future:
*This may depend on the feasibility that has no been check yet, see next section*
- Upload your DB train ticket QR code and let the app do the rest.
- Contemplate how much time you lost due to delays.
- Collect excuses ! A tree fell on your line ? how unlikely, but when you think about it, if it wasn't a tree, it would have been something else. So why not collect all the excuses and display them in a funny way.
- Gamification: earn badges for reaching certain delay milestones.
- Display statistics about your travels, e.g. how many times you were late, how many times you were on time (lol), how many times you were early (miracles CAN happen), what was your longest delay, what was your shortest delay, etc.
- See a total for all users, how much time was lost due to delays.
- Time is money ! Money in this app is represented by time lost due to delays. If you take DB trains, you'll be rich in no time!
- Guess what the next excuse will be for a chance to obtain as currency twice the time lost due to the delay it caused!
- Tips on how to manage anger and frustration when dealing with delays.
- Ideas to pass the time while waiting for a delayed train.
- Widgets to see your total delay time at a glance.
- Share your total delay time on social media.
- Partnerships with local businesses to offer discounts to users (based on their total delay time).
-> Buy discounts with money earned by delays ?
- Leaderboard: see how you rank against other users in terms of total delay time.
- Offering alternative routes when a connexion will be missed due to a delay.
- Your year recap with statistics that you can share on social media (à la Spotify Wrapped).
- Redirection to the DB website/app to request compensation for delays over the legal limit.
- In statistics: also display the amount of trains late vs trains on time + percentage.

### iOS integration
- Integrate with Apple Health to add the time lost due to delays to your "Time spent commuting" metric.
- Complications for Apple Watch to see your total delay time at a glance.


### Other ideas ? Please open an issue or a PR.

## What I have not figured out yet:
- How to get the data from the QR code.
- Some people have a subscription and don't have a QR code linked to their itinerary. How to handle that ? Location ? How do you tell this app which train you first planned on taking ?
- How to handle missed connections ?
-> If your train is late and it makes you miss your connection, the delay is not just the delay of the last train, but the arrival time your new unregistered train compared to the planned arrival time of the planned train. How to know the difference ? Using location and watching when you arrive within a certain range of the destination train station ?

## Design decisions
