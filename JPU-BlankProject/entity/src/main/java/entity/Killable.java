package entity;

public abstract class Killable {

		private boolean isAlive = true;

		public boolean isLifeStatus() {
			return isAlive;
		}

		public void setLifeStatus(boolean isAlive) {
			this.isAlive = isAlive;
		}
}
