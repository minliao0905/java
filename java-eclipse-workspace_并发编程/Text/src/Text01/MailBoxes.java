package Text01;


import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MailBoxes {
        private static Map<Integer,GuardeObject> boxes = new Hashtable<>();
        private static int id = 1;
        private static synchronized int generateId() {
        	return   id++;    //为产生唯一的id;
        	 
        }
        public static GuardeObject createGuardeObject() {
        	GuardeObject go = new GuardeObject(generateId());
        	boxes.put(go.getId(),go);
        	return go;
        }
        public static Set<Integer> getIds(){
        	return  boxes.keySet();
        }
		public static GuardeObject getguardeObject(int id) {
		
			return boxes.remove(id);
		}
}
  