class Solution {
public:
    char *m_pData;
    Solution() {
        this->m_pData = NULL;
    }
    Solution(char *pData) {
        this->m_pData = pData;
    }

    // Implement an assignment operator
    Solution operator=(const Solution &object) {
        if (this == &object) return *this;
        if (m_pData != NULL) delete[] m_pData;
        if (object.m_pData == NULL) {
            m_pData = NULL;
        } else {
            m_pData = new char[strlen(object.m_pData)];
            memcpy(m_pData, object.m_pData, strlen(object.m_pData));
        }
        return *this;
    }
};