import request from '@/utils/request'

// 查询我的审批列表
export function listApproval(query) {
  return request({
    url: '/approval/approval/list',
    method: 'get',
    params: query
  })
}

// 查询我的审批详细
export function getApproval(id) {
  return request({
    url: '/approval/approval/' + id,
    method: 'get'
  })
}

// 新增我的审批
export function addApproval(data) {
  return request({
    url: '/approval/approval',
    method: 'post',
    data: data
  })
}

// 修改我的审批
export function updateApproval(data) {
  return request({
    url: '/approval/approval',
    method: 'put',
    data: data
  })
}

// 删除我的审批
export function delApproval(id) {
  return request({
    url: '/approval/approval/' + id,
    method: 'delete'
  })
}
