import axios from 'axios'

const METRICS_API_BASE_URL = "http://localhost:8080/api/metricsService";
class SleepMetricsService {
  generateReport(recordType) {
    return axios.get(METRICS_API_BASE_URL + "/getReport/" + recordType);
  }
}
export default new SleepMetricsService();