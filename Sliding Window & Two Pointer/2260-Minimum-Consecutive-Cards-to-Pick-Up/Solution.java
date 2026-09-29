class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        int minCards = Integer.MAX_VALUE;

        for(int i = 0; i < cards.length; i++){
            int currentCard = cards[i];

            if(lastSeen.containsKey(currentCard)){
                int distance = i - lastSeen.get(currentCard) + 1;
                minCards = Math.min(minCards, distance);
            }

            lastSeen.put(currentCard, i);
        }

        return minCards == Integer.MAX_VALUE ? -1 : minCards;
    }
}
