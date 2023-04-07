import axios from 'axios'

const DREAM_API_BASE_URL = "http://localhost:8080/api/dreamService";
class DreamService {
  createDream(dream) {
    return axios.post(DREAM_API_BASE_URL + "/saveDream", dream);
  }

  updateDream(sleepMetrics, id) {
    return axios.put(DREAM_API_BASE_URL + "/updateDream/" + id, sleepMetrics);
  }
}
export default new DreamService();
