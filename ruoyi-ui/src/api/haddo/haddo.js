import request from '@/utils/request'

// 查询我的已办列表
export function listHaddo(query) {
  return request({
    url: '/haddo/haddo/list',
    method: 'get',
    params: query
  })
}

// 查询我的已办详细
export function getHaddo(id) {
  return request({
    url: '/haddo/haddo/' + id,
    method: 'get'
  })
}

// 新增我的已办
export function addHaddo(data) {
  return request({
    url: '/haddo/haddo',
    method: 'post',
    data: data
  })
}

// 修改我的已办
export function updateHaddo(data) {
  return request({
    url: '/haddo/haddo',
    method: 'put',
    data: data
  })
}

// 删除我的已办
export function delHaddo(id) {
  return request({
    url: '/haddo/haddo/' + id,
    method: 'delete'
  })
}
