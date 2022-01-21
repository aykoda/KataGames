

public class Bowling {

        private int rolls[] = new int[21];
        private int currentRoll = 0;
        private int knickedDownPins10 = 10;
        private int is10thFrame = 9;

        public void roll(int pins) {

            rolls[currentRoll++] = pins;
        }

        public int score() {
            int totalScore = 0;
            int frameIndex = 0;
            for (int frame = 0; frame < 10; frame++) {
                if (isStrike(frameIndex)) {
                    totalScore += knickedDownPins10
                               + (is10thFrame(frame)? spareBonus(frameIndex)
                                                  : strikeBonus(frameIndex));
                    frameIndex++;
                } else if (isSpare(frameIndex)) {
                    totalScore += knickedDownPins10 + spareBonus(frameIndex);
                    frameIndex += 2;
                } else { //isFrame
                    totalScore += sumKnockedDownPinsInFrame(frameIndex);
                    frameIndex += 2;
                }
            }
            return totalScore;
        }

        private boolean is10thFrame(int frame) {

            return frame == is10thFrame;
        }

        private boolean isStrike(int frameIndex) {

            return rolls[frameIndex] == knickedDownPins10;
        }
        private int strikeBonus(int frameIndex) {

            return rolls[frameIndex+1] + rolls[frameIndex+2];
        }

        private boolean isSpare(int frameIndex) {

            return rolls[frameIndex]+rolls[frameIndex+1] == knickedDownPins10;
        }

        private int spareBonus(int frameIndex) {

            return rolls[frameIndex+2];
        }

        private int sumKnockedDownPinsInFrame(int frameIndex) {

            return rolls[frameIndex] + rolls[frameIndex+1];
        }


    }


