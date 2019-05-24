package entity;

public abstract class Killable {

		private boolean lifeStatus = true;

		public boolean isLifeStatus() {
			return lifeStatus;
		}

		public void setLifeStatus(boolean lifeStatus) {
			this.lifeStatus = lifeStatus;
		}
}
