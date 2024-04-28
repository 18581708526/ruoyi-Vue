import request from '@/utils/request'

// 查询我的待办列表
export function listNeeddo(query) {
  return request({
    url: '/needdo/needdo/list',
    method: 'get',
    params: query
  })
}

// 查询我的待办详细
export function getNeeddo(id) {
  return request({
    url: '/needdo/needdo/' + id,
    method: 'get'
  })
}

// 新增我的待办
export function addNeeddo(data) {
  return request({
    url: '/needdo/needdo',
    method: 'post',
    data: data
  })
}

// 修改我的待办
export function updateNeeddo(data) {
  return request({
    url: '/needdo/needdo',
    method: 'put',
    data: data
  })
}

// 删除我的待办
export function delNeeddo(id) {
  return request({
    url: '/needdo/needdo/' + id,
    method: 'delete'
  })
}
