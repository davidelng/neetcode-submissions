class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < cars.length; i++) {
            int currPos = cars[i][0];
            int currSpeed = cars[i][1];
            double time = (double) (target-currPos)/currSpeed;
            if (stack.size() > 0 &&
                time <= stack.peek()
            ) {
                continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}
