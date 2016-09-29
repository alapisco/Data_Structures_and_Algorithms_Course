package algorithmicToolBox.greedyAlgorithms;


import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        /* A safe way to cover a segment by a point: choose the right endpoint. If
         segments are sorted by minimun right endpoint first, then it means that
         if another segment started before the endpoint it will end after it or
         in the same point. The right endpoint will cover all other segments
         that started before or segments that start in the same endpoint
         */
        
        
        // Sort segments by minimun right endpoint
        Arrays.sort(segments);

        // Store optimal points used
        ArrayList<Integer> optimalPoints = new ArrayList();

        // Iterate through each segment end point and discard all the segments 
        // that the endpoit covers
        for (int i = 0; i < segments.length; i++) {

            if (segments[i] != null) {
                int optimalPoint = segments[i].end;
                optimalPoints.add(optimalPoint);
                for (int j = i; j < segments.length; j++) {

                    if (segments[j]!=null && optimalPoint >= segments[j].start && optimalPoint <= segments[j].end) {
                        segments[j] = null;
                    }
                }
            }

        }

        // Convert optimalPoints to array 
        int[] optimalPointsArray = new int[optimalPoints.size()];
        for (int i = 0; i < optimalPointsArray.length; i++) {
            optimalPointsArray[i] = optimalPoints.get(i);
        }

        return optimalPointsArray;

    }

    private static class Segment implements Comparable<Segment> {

        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {

            if (this == null || o == null) {
                return 0;
            } else if (this.end < o.end) {
                return -1;
            } else if (this.end > o.end) {
                return 1;
            } else {
                return 0;
            }

        }

        @Override
        public String toString() {
            return start + "," + end;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
